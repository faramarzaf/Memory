package com.faramarz.tictacdev.workwithmemory.utility;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseApplication extends AppCompatActivity {

    static BaseApplication baseApp;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        baseApp = this;
    }

}
