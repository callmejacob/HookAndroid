package com.jacob.hookandroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jacob.hookandroid.dynamicproxy.Client
import com.jacob.hookandroid.hookactivity.SubActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        native_text.text = stringFromJNI()

        // jumpto activity
        jump_activity.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, SubActivity::class.java)
            startActivity(intent)
        }

        // 动态代理
        dynamic_proxy.setOnClickListener { Client.dynamicVisit() }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
