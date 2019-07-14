package com.example.infoapp.view;

import android.util.Pair;

import com.example.infoapp.features.ViewModels.FormItemView;

import java.util.ArrayList;
import java.util.HashMap;

public class FormActivityHelper {

    private ArrayList<FormItemView> items;
    private String formName;

    public FormActivityHelper(String formName){
        this.formName = formName;
        items = new ArrayList<>();
    }

    public void addItem(FormItemView item){
        items.add(item);
    }

    public ArrayList<FormItemView> getItems(){
        return items;
    }

    public HashMap<String,String> getAnswers(){
        HashMap<String, String> answers = new HashMap<>();
        answers.put("id", this.formName);
        for (FormItemView item: items) {
            Pair<String,String> pair = item.answer();
            answers.put(pair.first,pair.second);
        }
        return answers;
    }
}
