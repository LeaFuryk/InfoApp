package com.example.infoapp.features.Models;

import java.util.ArrayList;

public class Form {
    private ArrayList<FormItemAction> items;

    public Form(){
        items = new ArrayList<FormItemAction>();
    }

    public Form(ArrayList<FormItemAction> items){
        this.items = items;
    }

    public void addItem(FormItemAction item){
        this.items.add(item);
    }

    public void removeItem(FormItemAction item){
        this.items.remove(item);
    }

    public int count(){
        return items.size();
    }

    public ArrayList<FormItemAction> getItems(){
        return items;
    }
}
