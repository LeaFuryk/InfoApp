package com.example.infoapp.features.Models.ItemFactory;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.infoapp.features.Models.FormItem;

public interface FormItemFactory {

    FormItem execute(@NonNull final String question, @Nullable final String [] options) throws IllegalArgumentException;
}
