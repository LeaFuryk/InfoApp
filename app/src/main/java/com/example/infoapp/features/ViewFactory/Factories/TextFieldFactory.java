package com.example.infoapp.features.ViewFactory.Factories;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import com.example.infoapp.features.ViewFactory.Helpers.LayoutHelper;
import com.example.infoapp.features.ViewFactory.ViewFactory;
import com.example.infoapp.features.ViewModels.FormItemView;

public class TextFieldFactory implements ViewFactory {
    @Override
    public FormItemView createView(@NonNull Context context, @NonNull String question, @Nullable String[] options) {

        EditText editText = new EditText(context);
        editText.setHint(question);
        editText.setId(0);
        editText.setTextColor(Color.WHITE);
        editText.setHighlightColor(Color.WHITE);
        editText.setLinkTextColor(Color.WHITE);
        editText.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        FormItemView formItemView = LayoutHelper.basicView(context);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                final String answer = editText.getText().toString();
                if(!answer.equals("")){
                    formItemView.setAnswer(answer);
                    return true;
                }
                return false;
            }
        });
        formItemView.setQuestion(question);
        formItemView.addView(editText);

        return formItemView;
    }
}
