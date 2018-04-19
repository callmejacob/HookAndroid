package com.jacob.hookandroid.dynamicproxy;

import android.util.Log;

/**
 * Created by jacob on 2018/4/20.
 */

public class ProxySubject implements Subject {

    Subject mOrig;

    public ProxySubject(Subject orig) {
        mOrig = orig;
    }

    @Override
    public void visit(String name) {
        Log.w("fuck", "ProxySubject: " + name);
        mOrig.visit(name);
    }
}
