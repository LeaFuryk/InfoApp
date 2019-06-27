package com.example.infoapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.infoapp.R;
import com.example.infoapp.features.Models.FormItemType;
import com.example.infoapp.features.ViewFactory.AbstractViewFactory;
import com.example.infoapp.features.ViewModels.FormItemView;
import com.example.infoapp.presenter.FormPresenter;

public class FormActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button imageButton;

    private FormPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        imageButton = findViewById(R.id.register_button);
        imageButton.setBackgroundResource(R.drawable.tags_rounded_corners);

        linearLayout = findViewById(R.id.linear_layout);

        presenter = new FormPresenter(this);
    }

    public void drawItem(final String question, final String[] options, final FormItemType type){
        FormItemView itemView =AbstractViewFactory.provide(this,type,question,options);
        linearLayout.addView(itemView);
    }
}
