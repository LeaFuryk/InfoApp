package com.example.infoapp.features.Models;

public class QuestionItem implements FormItemAction{

    private String question;
    private QuestionType type;

    public QuestionItem(String question, QuestionType type){
        this.question = question;
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuestionType getType(){
        return this.type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    @Override
    public void execute(FormItemActioner actioner) {
        actioner.executeWithQuestion(this.question, this.type);
    }
}
