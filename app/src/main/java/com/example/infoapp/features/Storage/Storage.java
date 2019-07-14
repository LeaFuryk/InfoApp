package com.example.infoapp.features.Storage;

import android.content.Context;

public interface Storage<E> {

    E get(Context context, String id);
    void save(Context context, E element);
}
