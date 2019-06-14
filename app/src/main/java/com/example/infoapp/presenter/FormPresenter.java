package com.example.infoapp.presenter;

import com.example.infoapp.features.Models.Form;
import com.example.infoapp.features.Models.FormItemAction;
import com.example.infoapp.features.Models.FormItemActioner;
import com.example.infoapp.features.Models.QuestionType;
import com.example.infoapp.model.FormViewModel;
import com.example.infoapp.view.FormActivity;

import java.util.Iterator;

public class FormPresenter implements FormItemActioner {

    private FormActivity view;
    private FormViewModel model;

    public FormPresenter(FormActivity view){
        this.view = view;
        model = new FormViewModel();
        Form form = model.getForm();
        Iterator<FormItemAction> items = form.getItems();
        while (items.hasNext()){
            items.next().execute(this);
        }
    }

    public void createTextView(String question){
        view.generateInputTextField(question);
    }

    public void createDatePicker(String question){
        view.calendar(question);
    }

    private void createSpinner(String question, Iterator<String> options){
        view.createSpinner(question, this.adaptOptions(options));
    }

    private String[] adaptOptions(Iterator<String> options){
        String[] result = new String[100];
        int i = 0;
        while (options.hasNext()){
            result[i] = options.next();
            i++;
        }
        return result;
    }

    @Override
    public void executeWithQuestion(String question, QuestionType type) {
        if(type == QuestionType.TEXT_VIEW){
            this.createTextView(question);
        }else{
            this.createDatePicker(question);
        }
    }

    @Override
    public void executeWithOptions(String question, Iterator<String> options, QuestionType type) {
        this.createSpinner(question,options);
    }
}
