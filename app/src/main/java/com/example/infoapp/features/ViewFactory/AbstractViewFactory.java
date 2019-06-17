package com.example.infoapp.features.ViewFactory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.infoapp.features.Models.QuestionType;
import com.example.infoapp.features.ViewModels.FormItemView;

import java.util.HashMap;
import java.util.Map;


public class AbstractViewFactory {

    private static Map<QuestionType, ViewFactory> map;

    static {
        map = new HashMap<>();
    }

    public static FormItemView provide(@NonNull final Context context, @NonNull final QuestionType type, @NonNull final String question, @Nullable String[] options){
        return map.get(type).createView(context, question, options);
    }
}
