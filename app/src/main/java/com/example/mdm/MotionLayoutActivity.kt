package com.example.mdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_tablayout.*

class MotionLayoutActivity : AppCompatActivity() {

    private var selectedIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_layout)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false) //기본 타이틀 사용하지 않게 지정
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)   //뒤로가기 버튼 활성화
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_dehaze_24) //뒤로가기 버튼의 아이콘을 변경

        val motionLayout = findViewById<MotionLayout>(R.id.motion_container)

        val v1 = findViewById<View>(R.id.v1)
        val v2 = findViewById<View>(R.id.v2)
        val v3 = findViewById<View>(R.id.v3)

        v1.setOnClickListener {
            if (selectedIndex == 0) return@setOnClickListener

            motionLayout.setTransition(R.id.s2, R.id.s1) //orange to blue transition
            motionLayout.transitionToEnd()
            selectedIndex = 0
        }
        v2.setOnClickListener {
            if (selectedIndex == 1) return@setOnClickListener

            if (selectedIndex == 2) {
                motionLayout.setTransition(R.id.s3, R.id.s2)  //red to orange transition
            } else {
                motionLayout.setTransition(R.id.s1, R.id.s2) //blue to orange transition
            }
            motionLayout.transitionToEnd()
            selectedIndex = 1
        }
        v3.setOnClickListener {
            if (selectedIndex == 2) return@setOnClickListener

            motionLayout.setTransition(R.id.s2, R.id.s3) //orange to red transition
            motionLayout.transitionToEnd()
            selectedIndex = 2
        }
    }
}