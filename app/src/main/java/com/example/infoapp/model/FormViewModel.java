package com.example.infoapp.model;

import com.example.infoapp.features.Models.Form;
import com.example.infoapp.features.Models.OptionItem;
import com.example.infoapp.features.Models.QuestionItem;
import com.example.infoapp.features.Models.QuestionType;

import java.util.ArrayList;

public class FormViewModel{

    public Form getForm(){

        Form form = new Form();

        QuestionItem item = new QuestionItem("¿Como es tu nombre?", QuestionType.TEXT_VIEW);
        QuestionItem item1 = new QuestionItem("¿Cual es tu apellido?", QuestionType.TEXT_VIEW);
        QuestionItem item2 = new QuestionItem("Fecha de nacimiento", QuestionType.DATE_PIKER);

        ArrayList<String> colors = new ArrayList<>();
        colors.add("Rojo");
        colors.add("Azul");
        colors.add("Amarillo");

        QuestionItem item3 = new OptionItem("Color Favorito: ", QuestionType.RADIO_GROUP, colors);

        ArrayList<String> politicians = new ArrayList<>();
        politicians.add("Izquierda");
        politicians.add("Derecha");
        QuestionItem item4 = new OptionItem("¿Cual es tu posicion politica?", QuestionType.SPINNER, politicians);

        form.addItem(item);
        form.addItem(item2);
        form.addItem(item3);
        form.addItem(item4);
        form.addItem(item1);

        return form;
    }
}
