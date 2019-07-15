package com.example.infoapp.features.Models;

public class QuestionItem extends AbstractFormItem implements FormItem {

    public QuestionItem(String question, FormItemType type) {
        super(question, type);
    }

    @Override
    public void execute(FormItemReceiver actioner) {
        actioner.receive(this.getQuestion(), null, this.getType());
    }
}
