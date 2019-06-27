package com.example.infoapp.features.Models;

public class QuestionItem implements FormItem {

    private String question;
    private FormItemType type;

    public QuestionItem(String question, FormItemType type){
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

    @Override
    public void execute(FormItemReceiver actioner) {
        actioner.receive(this.question, null, this.type);
    }
}
