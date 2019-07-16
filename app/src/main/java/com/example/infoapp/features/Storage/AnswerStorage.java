package com.example.infoapp.features.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.infoapp.features.Storage.Helpers.AnswerParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class AnswerStorage {

    private static AnswerStorage instance;

    private AnswerStorage(){}

    public static AnswerStorage getInstance(){
        if (instance == null) {
            instance = new AnswerStorage();
        }
        return instance;
    }

    public ArrayList<HashMap<String, String>> get(Context context, String id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Answers", Context.MODE_PRIVATE);

        if(sharedPreferences.contains(id)){
            String form = sharedPreferences.getString(id,null);
            AnswerParser parser = new AnswerParser();
            ArrayList<HashMap<String, String>> parsedAnswers = parser.parse(form);
            return parsedAnswers;
        }else{
            return null;
        }
    }

    public void save(Context context, HashMap<String, String> element) {
        String id = element.get("id");
        element.remove("id");

        SharedPreferences sharedPreferences = context.getSharedPreferences("Answers", Context.MODE_PRIVATE);
        AnswerParser parser = new AnswerParser();
        String parsedAnswers;
        if(sharedPreferences.contains(id)) {
            String form = sharedPreferences.getString(id, null);
            parsedAnswers = parser.parse(element, form);
        }else {
            parsedAnswers = parser.parse(element, null);
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(id,parsedAnswers);
        editor.commit();

    }

    public Set<String> seeAnswers(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Answers", Context.MODE_PRIVATE);
        return sharedPreferences.getAll().keySet();
    }
}
