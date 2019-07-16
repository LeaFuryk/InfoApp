package com.example.infoapp.features.Models;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class Form {
    private String name;
    private ArrayList<FormItem> items;

    public Form(@NonNull final String name){
        this.name = name;
        items = new ArrayList<>();
    }

    public Form(@NonNull final String name,@NonNull final ArrayList<FormItem> items){
        this.name= name;
        this.items = items;
    }

    public void addItem(final FormItem item){
        this.items.add(item);
    }

    public void removeItem(final FormItem item){
        this.items.remove(item);
    }

    public int size(){
        return items.size();
    }

    public String getName(){
        return this.name;
    }

    public void setName(final String name){
        this.name = name;
    }

    public ArrayList<FormItem> getItems(){
        return items;
    }
}
