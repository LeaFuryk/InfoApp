package com.example.infoapp.features.ViewFactory.Helpers;

import android.graphics.Color;
import android.widget.TextView;

public class StyleSheetHelper {

    public static TextView setStyleSheet(TextView textView){
        textView.setTextColor(Color.WHITE);
        textView.setHintTextColor(Color.WHITE);
        textView.setHighlightColor(Color.WHITE);
        textView.setTextSize(20);
        return textView;
    }
}
