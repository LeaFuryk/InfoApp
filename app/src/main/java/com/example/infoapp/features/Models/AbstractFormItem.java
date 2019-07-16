package com.example.infoapp.features.Models;

import android.support.annotation.NonNull;

public abstract class AbstractFormItem {
    private String question;
    private FormItemType type;

    public AbstractFormItem(@NonNull final String question, @NonNull final FormItemType type){
        this.question = question;
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(final String question) {
        this.question = question;
    }

    public FormItemType getType(){
        return this.type;
    }

    public void setType(final FormItemType type) {
        this.type = type;
    }
}
