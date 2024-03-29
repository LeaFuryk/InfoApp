package com.example.infoapp.features.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.infoapp.features.Models.Form;
import com.example.infoapp.features.Storage.Helpers.FormParser;

import java.util.Set;

public class FormStorage{

    private static FormStorage instance;

    private FormStorage(){}

    public static FormStorage getInstance(){
        if (instance == null) {
            instance = new FormStorage();
        }
        return instance;
    }

    public Form get(Context context, String id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Forms", Context.MODE_PRIVATE);

        if(sharedPreferences.contains(id)){
            String form = sharedPreferences.getString(id,null);
            FormParser parser = new FormParser();
            Form parsedForm = parser.parse(form);
            return parsedForm;
        }else{
            return null;
        }
    }

    public void save(Context context, Form element) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Forms", Context.MODE_PRIVATE);
        FormParser parser = new FormParser();
        String parsedForm = parser.parse(element);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(element.getName(),parsedForm);
        editor.commit();
    }

    public Set<String> seeAnswers(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Forms", Context.MODE_PRIVATE);
        return sharedPreferences.getAll().keySet();
    }
}
