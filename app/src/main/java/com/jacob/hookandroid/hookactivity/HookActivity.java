package com.jacob.hookandroid.hookactivity;

import android.app.Instrumentation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HookActivity {

    public static void hook() {
        hookInstrumentation();
    }

    private static void hookInstrumentation() {
        try {
            Class ActivityThread = Class.forName("android.app.ActivityThread");
            Method currentActivityThreadMethod = ActivityThread.getDeclaredMethod("currentActivityThread");
            currentActivityThreadMethod.setAccessible(true);
            Object currentActivityThread = currentActivityThreadMethod.invoke(null);

            Field instrumentationField = ActivityThread.getDeclaredField("mInstrumentation");
            instrumentationField.setAccessible(true);
            Instrumentation instrumentation = (Instrumentation) instrumentationField.get(currentActivityThread);
            instrumentationField.set(currentActivityThread, new InstrumentationProxy(instrumentation));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
