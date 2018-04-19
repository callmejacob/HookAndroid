package com.jacob.hookandroid.dynamicproxy;

import android.util.Log;

/**
 * Created by jacob on 2018/4/20.
 */

public class RealSubject implements Subject {
    @Override
    public void visit(String name) {
        Log.w("fuck", "RealSubject: " + name);
    }
}
