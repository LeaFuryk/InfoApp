package com.example.infoapp.presenter;

import com.example.infoapp.features.Storage.AnswerStorage;
import com.example.infoapp.view.ResultsActivity;

import java.util.HashMap;

public class ResultsPresenter {
    private ResultsActivity view;

    public ResultsPresenter(ResultsActivity view){
        this.view = view;
    }

    public HashMap<String,String> getAnswers(String option){
        return AnswerStorage.getInstance().get(view.getApplicationContext(), option);
    }
}
