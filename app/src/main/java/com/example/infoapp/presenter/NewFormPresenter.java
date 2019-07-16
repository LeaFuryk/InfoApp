package com.example.infoapp.presenter;

import com.example.infoapp.features.Models.Form;
import com.example.infoapp.features.Models.FormItem;
import com.example.infoapp.features.Models.FormItemType;
import com.example.infoapp.features.Models.ItemFactory.FormItemAbstractFactory;
import com.example.infoapp.features.Storage.FormStorage;
import com.example.infoapp.view.NewFormActivity;

public class NewFormPresenter {

    private static final String SUCCESSFUL_SENTENCE = "Form saved succesfully";
    private static final String FAILURE_SENTENCE = "You can't save an empty form";

    private NewFormActivity view;
    private Form form;

    public  NewFormPresenter(NewFormActivity view, String formName){
        this.view = view;
        this.form = new Form(formName);
    }

    public void addItem(String question, String formType, String [] options){
        try {
            FormItem item = FormItemAbstractFactory.provide(question, FormItemType.valueOf(formType), options);
            form.addItem(item);
            view.drawItem(question,FormItemType.valueOf(formType), options);
        }catch (IllegalArgumentException e){
            view.showToast(e.getMessage());
        }
    }

    public void saveForm(){
        if (this.form.getItems().size() > 0){
            FormStorage.getInstance().save(view.getApplicationContext(), form);
            view.showToast(SUCCESSFUL_SENTENCE);
        }else {
            view.showToast(FAILURE_SENTENCE);
        }
    }
}
