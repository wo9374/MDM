package com.example.mdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            val intent  = Intent(this, TabLayoutActivity::class.java)
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent  = Intent(this, BottomNavigationActivity::class.java)
            startActivity(intent)
        }

        btn3.setOnClickListener {
            val intent  = Intent(this, MotionLayoutActivity::class.java)
            startActivity(intent)
        }
    }
}