package com.jacob.hookandroid.hookactivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jacob.hookandroid.R;

public class SubActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hookactivity);
    }
}
