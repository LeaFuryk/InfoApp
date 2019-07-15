package com.example.infoapp.features.Models;

public abstract class AbstractFormItem {
    private String question;
    private FormItemType type;

    public AbstractFormItem(String question, FormItemType type){
        this.question = question;
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public FormItemType getType(){
        return this.type;
    }

    public void setType(FormItemType type) {
        this.type = type;
    }
}
