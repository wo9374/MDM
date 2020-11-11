package com.example.mdm

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.mdm.fragment.FragmentControl
import com.example.mdm.fragment.FragmentPolicy
import com.example.mdm.fragment.FragmentState
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.activity_tablayout.*
import kotlinx.android.synthetic.main.activity_tablayout.toolbar

class BottomNavigationActivity : AppCompatActivity() {

    var fragList: ArrayList<Fragment> = ArrayList() //프래그먼트 리스트

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false) //기본 타이틀 사용하지 않게 지정
        //supportActionBar!!.setDisplayHomeAsUpEnabled(true)   //뒤로가기 버튼 활성화
        //supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_dehaze_24) //뒤로가기 버튼의 아이콘을 변경

        fragList = arrayListOf(FragmentControl(), FragmentState(), FragmentPolicy())

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        //프래그먼트 매니저에서 트랜잭션 객체 생성(각종 트랜잭션 작업들(추가, 삭제, 교체 등) 가능)
        for(i in 0 until fragList.size){
            transaction.add(R.id.navigation_frame, fragList[i])
            transaction.hide(fragList[i])
        }
        transaction.show(fragList[0]).commit()

        //navigation.inflateMenu(R.menu.menu_bottom_navi) //코드 메뉴 지정 방식
        navigation.setOnNavigationItemSelectedListener { item ->
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            for (i in 0 until fragList.size) { transaction.hide(fragList[i]) /*모든 프래그먼트 숨김*/}

            when (item.itemId) {
                R.id.control -> transaction.show(fragList[0])
                R.id.state -> transaction.show(fragList[1])
                R.id.policy ->transaction.show(fragList[2])
            }
            transaction.commit()
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_action_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            //TODO 액션바 메뉴 판별해서 코드 실행
        }
        return super.onOptionsItemSelected(item)
    }
}