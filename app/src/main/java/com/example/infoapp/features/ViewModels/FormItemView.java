package com.example.infoapp.features.ViewModels;

import android.content.Context;
import android.util.Pair;
import android.widget.LinearLayout;

public class FormItemView extends LinearLayout implements AnswerProvider  {

    private String question;
    private String answer;

    public FormItemView(Context context, String question) {
        super(context);
    }

    public FormItemView(Context context){
        super(context);
    }

    @Override
    public Pair<String, String> answer() {
        return new Pair<String,String>(question,answer);
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
