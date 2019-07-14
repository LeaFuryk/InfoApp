package com.example.infoapp.features.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.infoapp.features.Storage.Helpers.AnswerParser;

import java.util.HashMap;

public class AnswerStorage implements Storage<HashMap<String,String>> {

    private static AnswerStorage instance;

    private AnswerStorage(){}

    public static AnswerStorage getInstance(){
        return (instance == null) ? new AnswerStorage() : instance;
    }

    @Override
    public HashMap<String, String> get(Context context, String id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Answers", Context.MODE_PRIVATE);

        if(sharedPreferences.contains(id)){
            String form = sharedPreferences.getString(id,null);
            AnswerParser parser = new AnswerParser();
            HashMap<String,String> parsedAnswers = parser.parse(form);
            return parsedAnswers;
        }else{
            return null;
        }
    }

    @Override
    public void save(Context context, HashMap<String, String> element) {
        String id = element.get("id");
        element.remove("id");

        SharedPreferences sharedPreferences = context.getSharedPreferences("Answers", Context.MODE_PRIVATE);
        AnswerParser parser = new AnswerParser();
        String parsedAnswers = parser.parse(element);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(id,parsedAnswers);
        editor.commit();

    }
}
