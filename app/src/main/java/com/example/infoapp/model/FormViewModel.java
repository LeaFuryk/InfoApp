package com.example.infoapp.model;

import android.content.Context;

import com.example.infoapp.features.Models.Form;
import com.example.infoapp.features.Storage.AnswerStorage;
import com.example.infoapp.features.Storage.FormStorage;

import java.util.HashMap;

public class FormViewModel{

    public Form getForm(Context context, String id){
        return FormStorage.getInstance().get(context,id);
    }

    public void saveAnswers(Context context, HashMap<String,String> answers){
        AnswerStorage.getInstance().save(context,answers);
    }
}
