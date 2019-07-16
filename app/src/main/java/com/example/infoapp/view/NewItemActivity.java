package com.example.infoapp.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.infoapp.R;
import com.example.infoapp.features.Models.FormItemType;
import com.example.infoapp.features.ViewFactory.AbstractViewFactory;
import com.example.infoapp.features.ViewModels.FormItemView;

import java.util.ArrayList;

public class NewItemActivity extends AppCompatActivity {

    private static final String INTENT_QUESTION_VALUE = "QUESTION";
    private static final String INTENT_TYPE_VALUE = "TYPE";
    private static final String INTENT_OPTIONS_VALUE = "OPTIONS";

    private static final String INSERT_QUESTION_SENTENCE = "Insert your question: ";
    private static final String CHOOSE_OPTION_SENTENCE = "Choose the type: ";
    private static final String INSERT_OPTION_SENTENCE = "Insert option";

    private static final String ERROR_SENTENCE = "Question and ItemType must NOT be null";

    private LinearLayout layout;
    private Button itemOkButton;

    private FormItemView question;
    private FormItemView itemType;

    private ArrayList<FormItemView> options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        layout = findViewById(R.id.new_item_layout);

        options= new ArrayList<>();
        itemOkButton = findViewById(R.id.item_ok_button);

        this.configure();

    }

    private void configure(){
        question = AbstractViewFactory.provide(getApplicationContext(), FormItemType.TEXT_VIEW,INSERT_QUESTION_SENTENCE,null);
        layout.addView(question);

        String [] types = new String[FormItemType.values().length];

        for(int i=0; i< FormItemType.values().length; i++){
            types[i] = FormItemType.values()[i].name();
        }

        itemType = AbstractViewFactory.provide(getApplicationContext(), FormItemType.RADIO_GROUP,CHOOSE_OPTION_SENTENCE, types);
        layout.addView(itemType);

        this.addOptionButton();

        this.itemOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(question.answer().second == null || itemType.answer().second == null){
                    Toast toast = Toast.makeText(getApplicationContext(), ERROR_SENTENCE, Toast.LENGTH_LONG);
                    toast.show();
                }else{
                    String optionsString = "";

                    for(FormItemView item : options){
                        if(item.answer().second != null && !item.answer().second.equals("")){
                            optionsString += item.answer().second +",";
                        }
                    }
                    Intent intent = getIntent();
                    intent.putExtra(INTENT_QUESTION_VALUE, question.answer().second);
                    intent.putExtra(INTENT_TYPE_VALUE, itemType.answer().second);
                    intent.putExtra(INTENT_OPTIONS_VALUE, optionsString);
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    private void addOptionButton(){
        Button button = new Button(this.getApplicationContext());
        button.setText(R.string.add_option_new_item);
        button.setGravity(Gravity.CENTER);
        button.setBackgroundColor(Color.parseColor("#3770DF"));
        button.setTextColor(Color.WHITE);
        button.setTextSize(20);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormItemView itemView = AbstractViewFactory.provide(getApplicationContext(), FormItemType.TEXT_VIEW,INSERT_OPTION_SENTENCE,null);
                options.add(itemView);
                layout.addView(itemView);
            }
        });

        layout.addView(button);
    }

}
