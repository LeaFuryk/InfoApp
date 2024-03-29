package com.example.infoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.infoapp.view.ChooseActivity;
import com.example.infoapp.view.NameNewFormActivity;

public class MainActivity extends AppCompatActivity {

    private static final String OPTION_INTENT_VALUE = "OPTION";
    private static final String OPTION_SEE_FORMS_VALUE = "SEE_FORMS";
    private static final String OPTION_SEE_ANSWERS_VALUE = "SEE_RESULTS";

    private Button completeFormButton;
    private Button seeResultsButton;
    private Button newFormButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newFormButton = findViewById(R.id.new_form_button);
        completeFormButton = findViewById(R.id.complete_form_button);
        seeResultsButton = findViewById(R.id.see_results_button);

        this.configurateNewFormButton();
        this.configurateCompleteFormButton();
        this.configurateSeeResultsButton();

    }

    private void configurateNewFormButton(){
        newFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NameNewFormActivity.class);
                startActivity(intent);
            }
        });
    }

    private void configurateCompleteFormButton(){
        completeFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChooseActivity.class);
                intent.putExtra(OPTION_INTENT_VALUE, OPTION_SEE_FORMS_VALUE);
                startActivity(intent);
            }
        });
    }

    private void configurateSeeResultsButton() {
        seeResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChooseActivity.class);
                intent.putExtra(OPTION_INTENT_VALUE, OPTION_SEE_ANSWERS_VALUE);
                startActivity(intent);
            }
        });
    }

}