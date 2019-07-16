package com.example.infoapp.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.infoapp.R;
import com.example.infoapp.presenter.ResultsPresenter;

import java.util.ArrayList;
import java.util.HashMap;

public class ResultsActivity extends AppCompatActivity {

    private LinearLayout layout;
    private ResultsPresenter presenter;
    private String option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        this.option = getIntent().getStringExtra("VALUE");
        layout = findViewById(R.id.results_list);

        presenter = new ResultsPresenter(this);

        this.configure();
    }

    private void configure(){
        ArrayList<HashMap<String,String>> values = this.presenter.getAnswers(this.option);
        for(HashMap<String,String> map: values){

            TextView titleView = this.getTextView();
            String titleText = "Answer: ";
            titleView.setText(titleText);
            this.layout.addView(titleView);

            for (String key: map.keySet()){
                TextView textView = this.getTextView();
                String text = key + ": "+ map.get(key);
                textView.setText(text);
                this.layout.addView(textView);
            }
        }
    }

    private TextView getTextView(){
        final ViewGroup.LayoutParams layoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((LinearLayout.LayoutParams) layoutParams).setMargins(20,20,20,0);

        TextView textView = new TextView(this.getApplicationContext());
        textView.setGravity(Gravity.LEFT);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(20);

        return textView;
    }
}
