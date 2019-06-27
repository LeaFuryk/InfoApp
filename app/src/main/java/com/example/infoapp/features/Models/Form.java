package com.example.infoapp.features.Models;

import java.util.ArrayList;

public class Form {
    private ArrayList<FormItem> items;

    public Form(){
        items = new ArrayList<>();
    }

    public Form(ArrayList<FormItem> items){
        this.items = items;
    }

    public void addItem(FormItem item){
        this.items.add(item);
    }

    public void removeItem(FormItem item){
        this.items.remove(item);
    }

    public int size(){
        return items.size();
    }

    public ArrayList<FormItem> getItems(){
        return items;
    }
}
