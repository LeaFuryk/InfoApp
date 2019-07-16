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

    private static final String INTENT_FORM_NAME_VALUE = "FORM_NAME";
    private static final String ERROR_SENTENCE = "Name must NOT be null";
    private static final String INSERT_NAME_SENTENCE = "Insert your form name: ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_new_form);

        layout = findViewById(R.id.name_new_form);

        FormItemView itemView = AbstractViewFactory.provide(this, FormItemType.TEXT_VIEW,INSERT_NAME_SENTENCE,null);
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
                    intent.putExtra(INTENT_FORM_NAME_VALUE, answer);
                    startActivity(intent);
                }else {
                    Toast toast = Toast.makeText(getApplicationContext(), ERROR_SENTENCE, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }
}
