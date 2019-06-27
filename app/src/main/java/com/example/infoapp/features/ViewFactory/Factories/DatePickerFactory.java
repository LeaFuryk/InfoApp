package com.example.infoapp.features.ViewFactory.Factories;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.infoapp.R;
import com.example.infoapp.features.ViewFactory.Helpers.LayoutHelper;
import com.example.infoapp.features.ViewFactory.Helpers.StyleSheetHelper;
import com.example.infoapp.features.ViewFactory.ViewFactory;
import com.example.infoapp.features.ViewModels.FormItemView;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.getInstance;

public class DatePickerFactory implements ViewFactory {

    @Override
    public FormItemView createView(Context context, String question, String[] options) {

        FormItemView formView = LayoutHelper.basicView(context);
        formView.setOrientation(LinearLayout.VERTICAL);

        final TextView textView = new TextView(context);
        textView.setText(question);

        formView.addView(StyleSheetHelper.setStyleSheet(textView));

        final FormItemView dateLayout = LayoutHelper.basicView(context);
        dateLayout.setOrientation(LinearLayout.HORIZONTAL);

        TextView answerField = new TextView(context);
        answerField.setHint("dd/mm/yyyy");
        dateLayout.addView(StyleSheetHelper.setStyleSheet(answerField));

        final ImageButton mButton;
        mButton = new ImageButton(context);
        mButton.setImageResource(R.drawable.ic_calendar);
        mButton.setBackgroundResource(R.drawable.tags_rounded_corners);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePicker = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                        final int actualMonth = month + 1;
                        //Formateo el día obtenido: antepone el 0 si son menores de 10
                        final String formatedDay = (dayOfMonth < 10)? "0" + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                        //Formateo el mes obtenido: antepone el 0 si son menores de 10
                        final String formatedMonth = (actualMonth < 10)? "0" + String.valueOf(actualMonth):String.valueOf(actualMonth);
                        //Muestro la fecha con el formato deseado

                        String answer = formatedDay + "/" + formatedMonth + "/" + year;
                        answerField.setText(answer);
                        formView.setAnswer(answer);
                    }
                }, getInstance().get(YEAR), getInstance().get(MONTH), getInstance().get(DAY_OF_MONTH));
                //Muestro el widget
                datePicker.show();
            }
        });
        mButton.setPadding(25,0,0,0);
        dateLayout.addView(mButton);
        formView.addView(dateLayout);

        return formView;
    }
}
