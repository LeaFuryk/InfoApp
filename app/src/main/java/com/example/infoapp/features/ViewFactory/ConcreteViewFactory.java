package com.example.infoapp.features.ViewFactory;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.infoapp.R;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.getInstance;

public class ConcreteViewFactory implements ViewFactory {

    @Override
    public View datePicker(Context context, EditText answerField) {

        final LinearLayout layout = this.basicLayout(context);
        layout.setOrientation(LinearLayout.HORIZONTAL);

        answerField.setHint("dd/mm/yyyy");

        layout.addView(answerField);

        final ImageButton mButton;
        mButton = new ImageButton(context);
        mButton.setImageResource(R.drawable.ic_calendar);
        mButton.setBackgroundResource(R.drawable.tags_rounded_corners);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog recogerFecha = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                        final int mesActual = month + 1;
                        //Formateo el día obtenido: antepone el 0 si son menores de 10
                        final String diaFormateado = (dayOfMonth < 10)? "0" + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                        //Formateo el mes obtenido: antepone el 0 si son menores de 10
                        final String mesFormateado = (mesActual < 10)? "0" + String.valueOf(mesActual):String.valueOf(mesActual);
                        //Muestro la fecha con el formato deseado
                        answerField.setText(diaFormateado + "/" + mesFormateado + "/" + year);
                    }
                }, getInstance().get(YEAR), getInstance().get(MONTH), getInstance().get(DAY_OF_MONTH));
                //Muestro el widget
                recogerFecha.show();
            }
        });

        layout.addView(mButton);

        return layout;
    }

    @Override
    public View editTextField(@NonNull Context context, @NonNull String hint) {
        EditText editText = new EditText(context);
        editText.setHint(hint);
        editText.setId(0);
        return editText;
    }

    @Override
    public View radioGroup(@NonNull Context context, @Nullable String[] options, @NonNull RadioGroup.OnCheckedChangeListener listener) {

        final RadioButton[] radioButton = new RadioButton[options.length];
        RadioGroup radioGroup = new RadioGroup(context.getApplicationContext()); //create the RadioGroup
        radioGroup.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL
        for(int i=0; i<options.length; i++){
            radioButton[i]  = new RadioButton(context.getApplicationContext());
            radioButton[i].setText(options[i]);
            radioButton[i].setId(i);
            radioGroup.addView(radioButton[i]);
        }

        radioGroup.setOnCheckedChangeListener(listener);

        return radioGroup;
    }

    @Override
    public View spinner(@NonNull Context context, @Nullable String[] options, @NonNull AdapterView.OnItemSelectedListener listener) {

        final Spinner dropDown = new Spinner(context);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, options);
        dropDown.setAdapter(adapter);
        dropDown.setOnItemSelectedListener(listener);

        return dropDown;
    }

    private @NonNull LinearLayout basicLayout(Context context){
        final ViewGroup.LayoutParams layoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        final LinearLayout layout = new LinearLayout(context);
        layout.setLayoutParams(layoutParams);
        return layout;
    }
}
