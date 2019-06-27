package com.example.infoapp.features.ViewFactory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.infoapp.features.ViewModels.FormItemView;

public interface ViewFactory {

    FormItemView createView(@NonNull Context context, @NonNull String question, @Nullable String[] options);

    /*
    View datePicker(@NonNull Context context, @Nullable String question, @NonNull TextView answerField);

    View editTextField(@NonNull Context context, @NonNull String hint);

    View radioGroup(@NonNull Context context,@Nullable String question, @Nullable String [] options, @NonNull RadioGroup.OnCheckedChangeListener listener);

    View spinner(@NonNull Context context, @Nullable String question, @Nullable String [] options, @NonNull AdapterView.OnItemSelectedListener listener);
    */
}
