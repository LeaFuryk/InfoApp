package com.example.infoapp.features.Models;

import java.util.ArrayList;

public class Form {
    private String name;
    private ArrayList<FormItem> items;

    public Form(String name){
        this.name = name;
        items = new ArrayList<>();
    }

    public Form(String name, ArrayList<FormItem> items){
        this.name= name;
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

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<FormItem> getItems(){
        return items;
    }
}
