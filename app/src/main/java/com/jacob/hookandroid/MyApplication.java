package com.jacob.hookandroid;

import android.app.Application;

import com.jacob.hookandroid.hookactivity.HookActivity;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // hookInstrumentation activity
        HookActivity.hook();
    }

}
