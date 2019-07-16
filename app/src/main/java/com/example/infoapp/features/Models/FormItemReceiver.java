package com.example.infoapp.features.Models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public interface FormItemReceiver {

    void receive(@NonNull final String question, @Nullable final ArrayList<String> options, @NonNull final FormItemType type);

}
