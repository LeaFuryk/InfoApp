package com.example.infoapp.model;

import android.content.Context;

import com.example.infoapp.features.Models.Form;
import com.example.infoapp.features.Models.FormItem;
import com.example.infoapp.features.Models.FormItemType;
import com.example.infoapp.features.Models.OptionItem;
import com.example.infoapp.features.Models.QuestionItem;
import com.example.infoapp.features.Storage.AnswerStorage;
import com.example.infoapp.features.Storage.FormStorage;

import java.util.ArrayList;
import java.util.HashMap;

public class FormViewModel{

    public Form getForm(Context context, String id){

        Form form = new Form("form1");

        QuestionItem item = new QuestionItem("¿Como es tu nombre?", FormItemType.TEXT_VIEW);
        QuestionItem item1 = new QuestionItem("¿Cual es tu apellido?", FormItemType.TEXT_VIEW);
        QuestionItem item2 = new QuestionItem("Fecha de nacimiento", FormItemType.DATE_PIKER);

        ArrayList<String> colors = new ArrayList<>();
        colors.add("Rojo");
        colors.add("Azul");
        colors.add("Amarillo");

        FormItem item3 = new OptionItem("Color Favorito: ", FormItemType.RADIO_GROUP, colors);

        ArrayList<String> politicians = new ArrayList<>();
        politicians.add("Izquierda");
        politicians.add("Derecha");
        FormItem item4 = new OptionItem("¿Cual es tu posicion politica?", FormItemType.SPINNER, politicians);

        form.addItem(item);
        form.addItem(item2);
        form.addItem(item3);
        form.addItem(item4);
        form.addItem(item1);

        FormStorage.getInstance().save(context,form);

        return FormStorage.getInstance().get(context,id);
    }

    public void saveAnswers(Context context, HashMap<String,String> answers){
        AnswerStorage.getInstance().save(context,answers);
    }
}
