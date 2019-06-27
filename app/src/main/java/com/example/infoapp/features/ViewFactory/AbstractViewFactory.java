package com.example.infoapp.features.ViewFactory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.infoapp.features.Models.FormItemType;
import com.example.infoapp.features.ViewFactory.Factories.DatePickerFactory;
import com.example.infoapp.features.ViewFactory.Factories.RadioGroupFactory;
import com.example.infoapp.features.ViewFactory.Factories.SpinnerFactory;
import com.example.infoapp.features.ViewFactory.Factories.TextFieldFactory;
import com.example.infoapp.features.ViewModels.FormItemView;

import java.util.HashMap;
import java.util.Map;


public class AbstractViewFactory {

    private static Map<FormItemType, ViewFactory> map;

    static {
        map = new HashMap<>();
        map.put(FormItemType.DATE_PIKER, new DatePickerFactory());
        map.put(FormItemType.TEXT_VIEW, new TextFieldFactory());
        map.put(FormItemType.RADIO_GROUP, new RadioGroupFactory());
        map.put(FormItemType.SPINNER, new SpinnerFactory());
    }

    public static FormItemView provide(@NonNull final Context context, @NonNull final FormItemType type, @NonNull final String question, @Nullable String[] options){
        return map.get(type).createView(context, question, options);
    }
}
