package com.jacob.hookandroid.dynamicproxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by jacob on 2018/4/20.
 */

public class DynamicProxy implements InvocationHandler {

    private Object mOrig;

    public DynamicProxy(Object orig) {
        mOrig = orig;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Log.w("fuck", "now proxy with " + method.getName());

        Object result = method.invoke(mOrig, args);

        return result;
    }

}
