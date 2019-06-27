package com.example.infoapp.features.ViewFactory.Factories;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.infoapp.features.ViewFactory.Helpers.LayoutHelper;
import com.example.infoapp.features.ViewFactory.Helpers.StyleSheetHelper;
import com.example.infoapp.features.ViewFactory.ViewFactory;
import com.example.infoapp.features.ViewModels.FormItemView;

public class SpinnerFactory implements ViewFactory {
    @Override
    public FormItemView createView(@NonNull Context context, @NonNull String question, @Nullable String[] options) {

        FormItemView formItemView = LayoutHelper.basicView(context);
        if(question.length() < 25){
            formItemView.setOrientation(LinearLayout.HORIZONTAL);
        } else {
            formItemView.setOrientation(LinearLayout.VERTICAL);
        }
        formItemView.setQuestion(question);

        final Spinner dropDown = new Spinner(context);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, options);
        dropDown.setAdapter(adapter);
        dropDown.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                formItemView.setAnswer(options[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final TextView textView = new TextView(context);
        textView.setText(question);

        formItemView.addView(StyleSheetHelper.setStyleSheet(textView));
        formItemView.addView(dropDown);
        return formItemView;
    }
}
