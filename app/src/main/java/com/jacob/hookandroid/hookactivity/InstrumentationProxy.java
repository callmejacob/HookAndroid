package com.jacob.hookandroid.hookactivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import java.lang.reflect.Method;

public class InstrumentationProxy extends Instrumentation {

    private Instrumentation oldInstrumentation;

    public InstrumentationProxy(Instrumentation instrumentation) {
        oldInstrumentation = instrumentation;
    }

    // android P已经无效了
    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode, Bundle options) {
        // hookInstrumentation 提示
        Toast.makeText(who, "hookActivity now!!!", Toast.LENGTH_SHORT).show();

        try {
            Method execStartActivity = Instrumentation.class.getDeclaredMethod("execStartActivity",
                    Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, int.class, Bundle.class);
            execStartActivity.setAccessible(true);
            return (ActivityResult) execStartActivity.invoke(oldInstrumentation,
                    who, contextThread, token, target, intent, requestCode, options);
        } catch (Throwable e) {
            throw new RuntimeException("hookActivity error");
        }
    }

}
