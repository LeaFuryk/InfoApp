package com.example.infoapp.presenter;

import com.example.infoapp.features.Storage.AnswerStorage;
import com.example.infoapp.features.Storage.FormStorage;
import com.example.infoapp.view.ChooseActivity;

import java.util.Set;

public class ChoosePresenter {
    private ChooseActivity view;

    public ChoosePresenter(ChooseActivity view){
        this.view =view;
    }

    public Set<String> seeAnswers(){
        return AnswerStorage.getInstance().seeAnswers(view.getApplicationContext());
    }

    public Set<String> seeForms(){
        return FormStorage.getInstance().seeAnswers(view.getApplicationContext());
    }
}
