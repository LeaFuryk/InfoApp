package com.example.infoapp.features.Models;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class OptionItem extends AbstractFormItem implements FormItem {

    private ArrayList<String> options;

    public OptionItem(@NonNull final String question, @NonNull final FormItemType type, @NonNull final ArrayList<String> options) {
        super(question, type);
        this.options = options;
    }

    public ArrayList<String> getOptions(){
        return options;
    }

    public void addOption(final String option){
        options.add(option);
    }

    public String getOption(final int index){
        return options.get(index);
    }

    public void removeOption(final int index){
        options.remove(index);
    }

    @Override
    public void execute(@NonNull final FormItemReceiver actioner) {
        actioner.receive(super.getQuestion(),this.getOptions(), super.getType());
    }
}
