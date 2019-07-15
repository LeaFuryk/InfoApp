package com.example.infoapp.features.Models.ItemFactory;

import com.example.infoapp.features.Models.FormItem;

public interface FormItemFactory {

    FormItem execute(String question, String [] options) throws IllegalArgumentException;
}
