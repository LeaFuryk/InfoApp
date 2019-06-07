package com.example.infoapp;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linear_layout);

        this.generateInputTextField("Nombre: ");
        this.generateInputTextField("Apellido: ");

        this.generateButton("primer boton");
        this.createSpinner();
        createRadioButton();
        calendar();
    }

    public void generateInputTextField(String title){
        EditText editText = new EditText(this.getApplicationContext());
        editText.setText(title);
        linearLayout.addView(editText);
    }

    public void generateButton(String title){
        Button mButton1;
        mButton1 = new Button(this.getApplicationContext());
        mButton1.setText(title);
        linearLayout.addView(mButton1);
    }



    public void createSpinner(){
        Spinner dropDown = new Spinner(this.getApplicationContext());
        final String[] items = new String[]{"1", "2", "three"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropDown.setAdapter(adapter);
        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                generateInputTextField(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        linearLayout.addView(dropDown);
    }

    private void createRadioButton() {
        final RadioButton[] rb = new RadioButton[5];
        RadioGroup rg = new RadioGroup(this.getApplicationContext()); //create the RadioGroup
        rg.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL
        for(int i=0; i<5; i++){
            rb[i]  = new RadioButton(this);
            rb[i].setText("option "+i);
            rb[i].setId(i);
            rg.addView(rb[i]);
        }
        linearLayout.addView(rg);//you add the whole RadioGroup to the layout

    }

    public void calendar(){
        LinearLayout linearLayout1 = new LinearLayout(this.getApplicationContext());
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);

        EditText editText = new EditText(this.getApplicationContext());
        editText.setHint("dd/mm/yyyy");

        linearLayout1.addView(editText);

        Button mButton;
        mButton = new Button(this.getApplicationContext());
        mButton.setText("cal");

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker datePicker = new DatePicker(getApplicationContext());
                linearLayout.addView(datePicker);
            }
        });
        linearLayout1.addView(mButton);

        linearLayout.addView(linearLayout1);

    }
}
