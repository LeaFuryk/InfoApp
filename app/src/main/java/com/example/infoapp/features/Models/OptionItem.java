package com.example.infoapp.features.Models;

import java.util.ArrayList;

public class OptionItem extends AbstractFormItem implements FormItem {

    private ArrayList<String> options;

    public OptionItem(String question, FormItemType type, ArrayList<String> options) {
        super(question, type);
        this.options = options;
    }

    public ArrayList<String> getOptions(){
        return options;
    }

    public void addOption(String option){
        options.add(option);
    }

    public String getOption(int index){
        return options.get(index);
    }

    public void removeOption(int index){
        options.remove(index);
    }

    @Override
    public void execute(FormItemReceiver actioner) {
        actioner.receive(super.getQuestion(),this.getOptions(), super.getType());
    }
}
