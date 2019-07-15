package com.example.infoapp.features.Models.ItemFactory;

import com.example.infoapp.features.Models.FormItem;
import com.example.infoapp.features.Models.FormItemType;
import com.example.infoapp.features.Models.OptionItem;

import java.util.ArrayList;

public class RadioGroupFactory implements FormItemFactory {
    @Override
    public FormItem execute(String question, String[] options) throws IllegalArgumentException {
        if(options == null){
            throw new IllegalArgumentException("Radio Group should have options");
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i= 0; i< options.length; i++){
            if(options[i] != null && !options[i].equals("")){
                list.add(options[i]);
            }
        }
        return new OptionItem(question, FormItemType.RADIO_GROUP, list);
    }
}
