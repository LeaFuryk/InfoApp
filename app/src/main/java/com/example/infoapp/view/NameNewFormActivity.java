package com.example.infoapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.infoapp.R;
import com.example.infoapp.features.Models.FormItemType;
import com.example.infoapp.features.ViewFactory.AbstractViewFactory;
import com.example.infoapp.features.ViewModels.FormItemView;

import static android.view.Gravity.CENTER;

public class NameNewFormActivity extends AppCompatActivity {

    private LinearLayout layout;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_new_form);

        layout = findViewById(R.id.name_new_form);

        FormItemView itemView = AbstractViewFactory.provide(this, FormItemType.TEXT_VIEW,"Insert your form name: ",null);
        itemView.setGravity(CENTER);
        layout.addView(itemView);

        nextButton = findViewById(R.id.next_button);
        nextButton.setBackgroundResource(R.drawable.tags_rounded_corners);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemView.answer().second != null){
                    String answer = itemView.answer().second;
                    Intent intent = new Intent(getApplicationContext(),NewFormActivity.class);
                    intent.putExtra("FORM_NAME", answer);
                    startActivity(intent);
                }else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Name must NOT be null", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }
}
