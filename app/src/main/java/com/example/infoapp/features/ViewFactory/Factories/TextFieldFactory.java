package com.example.infoapp.features.ViewFactory.Factories;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

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

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                final String answer = editText.getText().toString();
                if(!answer.equals("")){
                    formItemView.setAnswer(answer);
                }
            }
        });

        formItemView.setQuestion(question);
        formItemView.addView(editText);

        return formItemView;
    }
}
