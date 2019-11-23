package com.faramarz.tictacdev.workwithmemory.utility;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PublicMethods {

    public static void shortToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void longToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static String getBtnText(Button button) {
        return button.getText().toString();
    }

    public static String getEditText(EditText editText) {
        return editText.getText().toString();
    }

    public static String getTextView(TextView textView) {
        return textView.getText().toString();
    }

}
