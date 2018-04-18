package com.test.hookactivity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jacob.hookandroid.R
import com.jacob.hookandroid.hookactivity.SubActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jump.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, SubActivity::class.java)
            startActivity(intent)
        }
    }
}
