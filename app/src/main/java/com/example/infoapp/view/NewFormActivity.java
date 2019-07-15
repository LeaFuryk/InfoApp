package com.example.infoapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewItemActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String question = data.getStringExtra("QUESTION");
        String type = data.getStringExtra("TYPE");
        String options = data.getStringExtra("OPTIONS");
    }
}
