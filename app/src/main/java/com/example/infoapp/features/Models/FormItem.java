package com.example.infoapp.features.Models;

import android.support.annotation.NonNull;

public interface FormItem {

    void execute(@NonNull final FormItemReceiver actioner);
}
