package com.example.infoapp.features.ViewFactory.Helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.infoapp.features.ViewModels.FormItemView;

public class LayoutHelper {

    private static FormItemView setLayoutParams(FormItemView view){
        final ViewGroup.LayoutParams layoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((LinearLayout.LayoutParams) layoutParams).setMargins(5,40,5,40);
        view.setLayoutParams(layoutParams);

        return view;
    }

    public static @NonNull FormItemView basicView(Context context){
        FormItemView view = new FormItemView(context);
        view = LayoutHelper.setLayoutParams(view);
        return view;
    }
}
