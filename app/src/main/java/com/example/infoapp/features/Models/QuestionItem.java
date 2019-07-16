package com.example.infoapp.features.Models;

import android.support.annotation.NonNull;

public class QuestionItem extends AbstractFormItem implements FormItem {

    public QuestionItem(@NonNull final String question, @NonNull final FormItemType type) {
        super(question, type);
    }

    @Override
    public void execute(@NonNull final FormItemReceiver actioner) {
        actioner.receive(this.getQuestion(), null, this.getType());
    }
}
