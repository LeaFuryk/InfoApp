package com.example.infoapp.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.infoapp.R;
import com.example.infoapp.presenter.ChoosePresenter;

import java.util.Set;

public class ChooseActivity extends AppCompatActivity {

    private ChoosePresenter presenter;
    private String option;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        Intent intent = getIntent();
        this.option = intent.getStringExtra("OPTION");

        layout = findViewById(R.id.option_list);

        presenter = new ChoosePresenter(this);
        this.configure();
    }

    private void configure(){
        Set<String> options = null;
        if(option.equals("SEE_RESULTS")){
            options = presenter.seeAnswers();
        }else{
            options = presenter.seeForms();
        }
        for (String option : options){

            Button button = makeButton(option);
            layout.addView(button);
        }
    }

    private Button makeButton(String selection){
        final ViewGroup.LayoutParams layoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((LinearLayout.LayoutParams) layoutParams).setMargins(20,20,20,0);

        Button button = new Button(this.getApplicationContext());
        button.setWidth(200);
        button.setHeight(60);
        button.setText(selection);
        button.setGravity(Gravity.CENTER);
        button.setLayoutParams(layoutParams);
        button.setBackgroundColor(Color.parseColor("#3770DF"));
        button.setTextColor(Color.WHITE);
        button.setTextSize(20);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                if(option.equals("SEE_RESULTS")){
                   intent = new Intent(getApplicationContext(), ResultsActivity.class);
                }else{
                   intent = new Intent(getApplicationContext(), FormActivity.class);
                }
                intent.putExtra("VALUE", button.getText());
                startActivity(intent);
            }
        });

        return button;
    }
}
