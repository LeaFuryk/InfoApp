package com.example.infoapp.features.Storage.Helpers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.infoapp.features.Models.Form;
import com.example.infoapp.features.Models.FormItem;
import com.example.infoapp.features.Models.FormItemReceiver;
import com.example.infoapp.features.Models.FormItemType;
import com.example.infoapp.features.Models.OptionItem;
import com.example.infoapp.features.Models.QuestionItem;

import java.util.ArrayList;

public class FormParser implements FormItemReceiver {

    private String parse = "";

    public Form parse(String form){

        final String [] items = form.split(";");

        //Getting de form name
        final String [] name = items[0].split("name:");
        final Form parsedForm = new Form(name[1]);

        //Get each item
        for (int i = 1; i< items.length; i++){
            final FormItem item = this.parseItem(items[i]);
            parsedForm.addItem(item);
        }

        return parsedForm;
    }

    public String parse(Form form){
        this.parse = "";
        parse += "name:" +form.getName() +";";
        for (final FormItem item: form.getItems()) {
            this.parse += "item:[";
            item.execute(this);
            this.parse +="];";
        }
        return this.parse;
    }

    @Override
    public void receive(@NonNull String question, @Nullable ArrayList<String> options, @NonNull FormItemType type) {
        String item = "";
        item += "question:" + question + ",";
        item += "type:" + type;
        if(options !=null){
            item+=",options:{";
            for(int i= 0; i< options.size(); i++){
                if(i == options.size() -1){
                    item += options.get(i)+"}";
                }else {
                    item += options.get(i)+"-";
                }
            }
        }
        this.parse += item;
    }

    private FormItem parseItem(String item){

        String values = "";
        boolean founded = false;
        for (int i= 0; i< item.length() && !founded; i++){
            if(item.charAt(i) == '['){
                founded = true;
                values = item.substring(i +1, item.length()-1);
            }
        }
        final String [] separatedValues = values.split(",");

        final String question = separatedValues[0].split(":")[1];
        final String type = separatedValues[1].split(":")[1];

        ArrayList<String> options = null;
        if (separatedValues.length > 2){
            options = this.parseOptions(separatedValues[2]);
        }

        final FormItem formItem;
        if(options != null){
            formItem = new OptionItem(question,FormItemType.valueOf(type),options);
        }else{
            formItem = new QuestionItem(question,FormItemType.valueOf(type));
        }

        return formItem;
    }

    private ArrayList<String> parseOptions(String options){

        String parsedOptions = "";
        boolean founded = false;
        for(int i= 0; i<options.length() && !founded; i++){
            if(options.charAt(i) == '{'){
                founded = true;
                parsedOptions = options.substring(i+1,options.length() -1);
            }
        }

        final String [] finalOptions = parsedOptions.split("-");

        ArrayList<String> optionsArray = new ArrayList<>();
        for(int i= 0; i<finalOptions.length; i++){
            optionsArray.add(finalOptions[i]);
        }

        return optionsArray;
    }
}
