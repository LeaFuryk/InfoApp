package com.example.infoapp.features.Models.ItemFactory;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.infoapp.features.Models.FormItem;
import com.example.infoapp.features.Models.FormItemType;
import com.example.infoapp.features.Models.QuestionItem;

public class TextViewFactory implements FormItemFactory{
    @Override
    public FormItem execute(@NonNull final String question,@Nullable final String[] options) throws IllegalArgumentException {
        if(options != null){
            throw new IllegalArgumentException("TextView should not have options");
        }
        return new QuestionItem(question, FormItemType.TEXT_VIEW);
    }
}
