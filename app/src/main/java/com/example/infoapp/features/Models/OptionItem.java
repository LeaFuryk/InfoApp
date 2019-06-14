package com.example.infoapp.features.Models;

import java.util.ArrayList;

public class OptionItem extends QuestionItem implements FormItemAction{

    private ArrayList<String> options;

    public OptionItem(String question, QuestionType type, ArrayList<String> options) {
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
    public void execute(FormItemActioner actioner) {
        actioner.executeWithOptions(super.getQuestion(),this.getOptions(), super.getType());
    }
}
