package com.example.infoapp.features.ViewFactory;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.infoapp.R;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.getInstance;

public class ConcreteViewFactory {

    public View datePicker(Context context, String question, TextView answerField) {


    }

    public View editTextField(@NonNull Context context, @NonNull String hint) {

        EditText editText = new EditText(context);
        editText.setHint(hint);
        editText.setId(0);
        editText.setTextColor(Color.WHITE);
        editText.setHighlightColor(Color.WHITE);
        editText.setLinkTextColor(Color.WHITE);
        editText.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        return this.setLayoutParams(this.setStyleSheet(editText));
    }

    public View radioGroup(@NonNull Context context, String question, @Nullable String[] options, @NonNull RadioGroup.OnCheckedChangeListener listener) {

        LinearLayout layout = this.basicLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        final TextView textView = new TextView(context);
        textView.setText(question);

        layout.addView(this.setStyleSheet(textView));

        final RadioButton[] radioButton = new RadioButton[options.length];
        RadioGroup radioGroup = new RadioGroup(context.getApplicationContext()); //create the RadioGroup
        radioGroup.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL

        for(int i=0; i<options.length; i++){
            radioButton[i]  = new RadioButton(context.getApplicationContext());
            radioButton[i].setText(options[i]);
            radioButton[i].setId(i);
            radioButton[i].setButtonTintList(ColorStateList.valueOf(Color.WHITE));
            radioGroup.addView(this.setStyleSheet(radioButton[i]));
        }
        radioGroup.setOnCheckedChangeListener(listener);
        radioGroup.setPadding(0,10,0,0);
        layout.addView(radioGroup);

        return layout;
    }

    public View spinner(@NonNull Context context, String question, @Nullable String[] options, @NonNull AdapterView.OnItemSelectedListener listener) {

        LinearLayout layout = this.basicLayout(context);
        if(question.length() < 25){
            layout.setOrientation(LinearLayout.HORIZONTAL);
        } else {
            layout.setOrientation(LinearLayout.VERTICAL);
        }

        final Spinner dropDown = new Spinner(context);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, options);
        dropDown.setAdapter(adapter);
        dropDown.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        dropDown.setOnItemSelectedListener(listener);


        final TextView textView = new TextView(context);
        textView.setText(question);

        layout.addView(this.setStyleSheet(textView));
        layout.addView(dropDown);
        return layout;
    }



    private View setLayoutParams(View view){
        final ViewGroup.LayoutParams layoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((LinearLayout.LayoutParams) layoutParams).setMargins(5,40,5,40);
        view.setLayoutParams(layoutParams);

        return view;
    }

    private TextView setStyleSheet(TextView textView){
        textView.setTextColor(Color.WHITE);
        textView.setHintTextColor(Color.WHITE);
        textView.setTextSize(20);
        return textView;
    }
}

