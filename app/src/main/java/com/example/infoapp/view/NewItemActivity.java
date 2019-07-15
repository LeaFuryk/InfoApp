package com.example.infoapp.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.infoapp.R;
import com.example.infoapp.features.Models.FormItemType;
import com.example.infoapp.features.ViewFactory.AbstractViewFactory;
import com.example.infoapp.features.ViewModels.FormItemView;

import java.util.ArrayList;

public class NewItemActivity extends AppCompatActivity {

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
        question = AbstractViewFactory.provide(getApplicationContext(), FormItemType.TEXT_VIEW,"Insert your question: ",null);
        layout.addView(question);

        String [] types = new String[FormItemType.values().length];

        for(int i=0; i< FormItemType.values().length; i++){
            types[i] = FormItemType.values()[i].name();
        }

        itemType = AbstractViewFactory.provide(getApplicationContext(), FormItemType.RADIO_GROUP,"Choose the type: ", types);
        layout.addView(itemType);

        this.addOptionButton();
    }

    private void addOptionButton(){
        Button button = new Button(this.getApplicationContext());
        button.setText("Add option");
        button.setGravity(Gravity.CENTER);
        button.setBackgroundColor(Color.parseColor("#3770DF"));
        button.setTextColor(Color.WHITE);
        button.setTextSize(20);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormItemView itemView = AbstractViewFactory.provide(getApplicationContext(), FormItemType.TEXT_VIEW,"Insert option",null);
                options.add(itemView);
                layout.addView(itemView);
            }
        });

        layout.addView(button);
    }

}
