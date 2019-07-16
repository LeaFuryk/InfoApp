package com.example.infoapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.infoapp.MainActivity;
import com.example.infoapp.R;
import com.example.infoapp.features.Models.FormItemType;
import com.example.infoapp.features.ViewFactory.AbstractViewFactory;
import com.example.infoapp.features.ViewModels.FormItemView;
import com.example.infoapp.presenter.NewFormPresenter;

public class NewFormActivity extends AppCompatActivity {

    private static final String INTENT_QUESTION_VALUE = "QUESTION";
    private static final String INTENT_TYPE_VALUE = "TYPE";
    private static final String INTENT_OPTIONS_VALUE = "OPTIONS";
    private static final String INTENT_FORM_NAME_VALUE = "FORM_NAME";

    private Button addItemButton;
    private Button finishFormButton;
    private LinearLayout layout;

    private String formName;
    private NewFormPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_form);
        Intent intent = getIntent();
        formName = intent.getStringExtra(INTENT_FORM_NAME_VALUE);
        presenter = new NewFormPresenter(this, formName);

        layout = findViewById(R.id.new_form_layout);

        finishFormButton = findViewById(R.id.finish_form_button);
        finishFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.saveForm();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

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
        String question = data.getStringExtra(INTENT_QUESTION_VALUE);
        String type = data.getStringExtra(INTENT_TYPE_VALUE);
        String options = data.getStringExtra(INTENT_OPTIONS_VALUE);

        String [] separatedOptions = null;

        if (options != null && !options.equals("")){
            separatedOptions = options.split(",");
        }

        presenter.addItem(question,type,separatedOptions);
    }

    public void showToast(String message){
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.show();
    }

    public void drawItem(String question, FormItemType type, String [] options){
        FormItemView item = AbstractViewFactory.provide(this, type, question, options);
        layout.addView(item);
    }
}
