package com.example.infoapp.features.Models.ItemFactory;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.infoapp.features.Models.FormItem;
import com.example.infoapp.features.Models.FormItemType;

import java.util.HashMap;

public class FormItemAbstractFactory {

    private static HashMap<FormItemType, FormItemFactory> map;

    static {
        map = new HashMap<>();
        map.put(FormItemType.DATE_PIKER, new DatePickerFactory());
        map.put(FormItemType.TEXT_VIEW, new TextViewFactory());
        map.put(FormItemType.RADIO_GROUP, new RadioGroupFactory());
        map.put(FormItemType.SPINNER, new SpinnerFactory());
    }

    public static FormItem provide(@NonNull String questions,@NonNull FormItemType type,@Nullable String [] options) throws IllegalArgumentException{
        return map.get(type).execute(questions,options);
    }
}
