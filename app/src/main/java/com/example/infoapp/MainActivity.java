package com.example.infoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.infoapp.view.FormActivity;

public class MainActivity extends AppCompatActivity {

    private Button newFormButton;
    private Button saveDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newFormButton = findViewById(R.id.new_form_button);
        saveDataButton = findViewById(R.id.save_data_button);

        this.configurateNewFormButton();
        this.configurateSaveDataButton();

    }

    private void configurateNewFormButton(){
        newFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FormActivity.class);
                startActivity(intent);
            }
        });
    }

    private void configurateSaveDataButton() {
        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Nothing still
            }
        });
    }

}