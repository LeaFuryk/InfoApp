package com.example.infoapp.features.ViewFactory;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
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
import android.widget.TextView;

import com.example.infoapp.R;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.getInstance;

public class ConcreteViewFactory implements ViewFactory {

    @Override
    public View datePicker(Context context, String question, EditText answerField) {

        LinearLayout layout = this.basicLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        final TextView textView = new TextView(context);
        textView.setTextSize(17);
        textView.setTextColor(Color.BLACK);
        textView.setText(question);

        layout.addView(textView);

        final LinearLayout dateLayout = this.basicLayout(context);
        dateLayout.setOrientation(LinearLayout.HORIZONTAL);

        answerField.setHint("dd/mm/yyyy");

        dateLayout.addView(answerField);

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
        dateLayout.addView(mButton);
        layout.addView(dateLayout);

        return layout;
    }

    @Override
    public View editTextField(@NonNull Context context, @NonNull String hint) {

        EditText editText = new EditText(context);
        editText.setHint(hint);
        editText.setId(0);

        return this.setLayoutParams(editText);
    }

    @Override
    public View radioGroup(@NonNull Context context, String question, @Nullable String[] options, @NonNull RadioGroup.OnCheckedChangeListener listener) {

        LinearLayout layout = this.basicLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        final TextView textView = new TextView(context);
        textView.setTextSize(17);
        textView.setTextColor(Color.BLACK);
        textView.setText(question);

        layout.addView(textView);

        final RadioButton[] radioButton = new RadioButton[options.length];
        RadioGroup radioGroup = new RadioGroup(context.getApplicationContext()); //create the RadioGroup
        radioGroup.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL
        for(int i=0; i<options.length; i++){
            radioButton[i]  = new RadioButton(context.getApplicationContext());
            radioButton[i].setText(options[i]);
            radioButton[i].setId(i);
            radioButton[i].setTextSize(17);
            radioButton[i].setTextColor(Color.BLACK);
            radioGroup.addView(radioButton[i]);
        }
        radioGroup.setOnCheckedChangeListener(listener);

        layout.addView(radioGroup);

        return layout;
    }

    @Override
    public View spinner(@NonNull Context context, String question, @Nullable String[] options, @NonNull AdapterView.OnItemSelectedListener listener) {

        LinearLayout layout = this.basicLayout(context);
        layout.setOrientation(LinearLayout.HORIZONTAL);

        final Spinner dropDown = new Spinner(context);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, options);
        dropDown.setAdapter(adapter);
        dropDown.setOnItemSelectedListener(listener);



        final TextView textView = new TextView(context);
        textView.setTextSize(17);
        textView.setTextColor(Color.BLACK);
        textView.setText(question);

        layout.addView(textView);
        layout.addView(dropDown);
        return layout;
    }

    private @NonNull LinearLayout basicLayout(Context context){
        LinearLayout layout = new LinearLayout(context);
        layout = (LinearLayout) this.setLayoutParams(layout);
        return layout;
    }

    private View setLayoutParams(View view){
        final ViewGroup.LayoutParams layoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((LinearLayout.LayoutParams) layoutParams).setMargins(5,15,5,15);
        view.setLayoutParams(layoutParams);

        return view;
    }
}
