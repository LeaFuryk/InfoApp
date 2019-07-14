package com.example.infoapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.infoapp.R;

public class NewFormActivity extends AppCompatActivity {

    private Button addItemButton;
    private LinearLayout layout;

    private String formName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_form);
        Intent intent = getIntent();
        formName = intent.getStringExtra("FORM_NAME");

        layout = findViewById(R.id.new_form_layout);

        addItemButton = findViewById(R.id.add_item_button);
        addItemButton.setBackgroundResource(R.drawable.tags_rounded_corners);
    }


}
