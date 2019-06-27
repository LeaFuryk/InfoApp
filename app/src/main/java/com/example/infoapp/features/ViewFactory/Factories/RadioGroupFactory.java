package com.example.infoapp.features.ViewFactory.Factories;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.infoapp.features.ViewFactory.Helpers.LayoutHelper;
import com.example.infoapp.features.ViewFactory.Helpers.StyleSheetHelper;
import com.example.infoapp.features.ViewFactory.ViewFactory;
import com.example.infoapp.features.ViewModels.FormItemView;

public class RadioGroupFactory implements ViewFactory {
    @Override
    public FormItemView createView(@NonNull Context context, @NonNull String question, @Nullable String[] options) {
        FormItemView formItemView = LayoutHelper.basicView(context);
        formItemView.setOrientation(LinearLayout.VERTICAL);
        formItemView.setQuestion(question);

        final TextView textView = new TextView(context);
        textView.setText(question);

        formItemView.addView(StyleSheetHelper.setStyleSheet(textView));

        final RadioButton[] radioButton = new RadioButton[options.length];
        RadioGroup radioGroup = new RadioGroup(context.getApplicationContext()); //create the RadioGroup
        radioGroup.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL

        for(int i=0; i<options.length; i++){
            radioButton[i]  = new RadioButton(context.getApplicationContext());
            radioButton[i].setText(options[i]);
            radioButton[i].setId(i);
            radioButton[i].setButtonTintList(ColorStateList.valueOf(Color.WHITE));
            radioGroup.addView(StyleSheetHelper.setStyleSheet(radioButton[i]));
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                formItemView.setAnswer(radioButton[checkedId].getText().toString());
            }
        });
        radioGroup.setPadding(0,10,0,0);
        formItemView.addView(radioGroup);

        return formItemView;
    }
}
