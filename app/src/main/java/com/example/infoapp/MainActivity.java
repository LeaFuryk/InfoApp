package com.example.infoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.infoapp.features.ViewFactory.ConcreteViewFactory;
import com.example.infoapp.features.ViewFactory.ViewFactory;

public class MainActivity extends AppCompatActivity {

    private ViewFactory viewFactory;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFactory = new ConcreteViewFactory();

        linearLayout = findViewById(R.id.linear_layout);

        this.generateInputTextField("Nombre: ");
        this.generateInputTextField("Apellido: ");

        this.createSpinner();
        createRadioButton();
        calendar();
    }

    public void generateInputTextField(String title){
        View view = viewFactory.editTextField(this.getApplicationContext(),title);
        linearLayout.addView(view);
    }

    public void createSpinner(){
        final String[] items = new String[]{"1", "2", "3"};
        View view = viewFactory.spinner(this,items, new AdapterView.OnItemSelectedListener() {
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
        linearLayout.addView(view);
    }

    private void createRadioButton() {

        String [] options = {"primera","segunda","tercera"};
         View radioGroup = viewFactory.radioGroup(this, options, new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId) {
                 Toast toast1 =
                         Toast.makeText(getApplicationContext(),
                                 options[checkedId], Toast.LENGTH_SHORT);

                 toast1.show();
             }
         });

        linearLayout.addView(radioGroup);//you add the whole RadioGroup to the layout

    }

    public void calendar(){
        EditText editText = new EditText(this.getApplicationContext());
        linearLayout.addView(viewFactory.datePicker(this,editText));
    }
}