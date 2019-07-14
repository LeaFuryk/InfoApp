package com.example.infoapp.presenter;

import com.example.infoapp.features.Models.Form;
import com.example.infoapp.features.Models.FormItem;
import com.example.infoapp.features.Models.FormItemReceiver;
import com.example.infoapp.features.Models.FormItemType;
import com.example.infoapp.model.FormViewModel;
import com.example.infoapp.view.FormActivity;

import java.util.ArrayList;

public class FormPresenter implements FormItemReceiver {

    private FormActivity view;
    private FormViewModel model;

    public FormPresenter(FormActivity view){
        this.view = view;
        model = new FormViewModel();
        Form form = model.getForm(view.getApplicationContext(), "form1");

        for (FormItem item: form.getItems()) {
            item.execute(this);
        }
    }

    private String[] adaptOptions(ArrayList<String> options){
        String[] result = new String[options.size()];
        for (int i= 0; i < options.size(); i++){
            result[i] = options.get(i);
        }
        return result;
    }

    @Override
    public void receive(String question, ArrayList<String> options, FormItemType type) {
        if (options != null) {
            view.drawItem(question, this.adaptOptions(options), type);
        }else {
            view.drawItem(question, null, type);
        }
    }
}
