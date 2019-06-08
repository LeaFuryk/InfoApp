package com.example.infoapp.features.ViewFactory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public interface ViewFactory {

    View datePicker(@NonNull Context context,@NonNull EditText answerField);

    View editTextField(@NonNull Context context, @NonNull String hint);

    View radioGroup(@NonNull Context context, @Nullable String [] options, @NonNull RadioGroup.OnCheckedChangeListener listener);

}
