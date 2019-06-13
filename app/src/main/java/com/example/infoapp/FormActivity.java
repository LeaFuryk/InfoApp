package com.example.infoapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infoapp.features.ViewFactory.ConcreteViewFactory;
import com.example.infoapp.features.ViewFactory.ViewFactory;

public class FormActivity extends AppCompatActivity {

    private ViewFactory viewFactory;
    private LinearLayout linearLayout;
    private Button imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        imageButton = findViewById(R.id.register_button);
        imageButton.setBackgroundResource(R.drawable.tags_rounded_corners);
        viewFactory = new ConcreteViewFactory();

        linearLayout = findViewById(R.id.linear_layout);

        this.generateInputTextField("Nombre: ");
        this.generateInputTextField("Apellido: ");

        this.createSpinner();
        this.createRadioButton();
        this.calendar();
    }

    public void generateInputTextField(String title){
        View view = viewFactory.editTextField(this.getApplicationContext(),title);
        this.addToLayoutOnCardView(view);
    }

    public void createSpinner(){
        final String[] items = new String[]{"1", "2", "3"};
        String question = "This is a very very very vyer long question";
        View view = viewFactory.spinner(this, question, items, new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                items[position], Toast.LENGTH_SHORT);

                toast1.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        this.addToLayoutOnCardView(view);
    }

    private void createRadioButton() {

        String [] options = {"primera","segunda","tercera"};
        String question = "¿Como saliste en la carrera?";
        View radioGroup = viewFactory.radioGroup(this, question, options, new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                options[checkedId], Toast.LENGTH_SHORT);

                toast1.show();
            }
        });

        this.addToLayoutOnCardView(radioGroup);

    }

    public void calendar(){
        TextView editText = new TextView(this.getApplicationContext());
        String question = "Birth day: ";
        View calendarView = viewFactory.datePicker(this, question, editText);
        this.addToLayoutOnCardView(calendarView);
    }

    private void addToLayoutOnCardView(View view){
        CardView cardView = new CardView(this.getApplicationContext());
        cardView.addView(view);
        cardView.setCardBackgroundColor(Color.parseColor("#81A6F1"));
        linearLayout.addView(cardView);
    }
}
