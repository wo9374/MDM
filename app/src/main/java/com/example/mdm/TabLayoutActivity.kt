package com.example.mdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.mdm.fragment.FragmentControl
import com.example.mdm.fragment.FragmentPolicy
import com.example.mdm.fragment.FragmentState
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tablayout.*


class TabLayoutActivity : AppCompatActivity() {

    var fragList: ArrayList<Fragment> = ArrayList() //프래그먼트 리스트
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false) //기본 타이틀 사용하지 않게 지정
        //supportActionBar!!.setDisplayHomeAsUpEnabled(true)   //뒤로가기 버튼 활성화
        //supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_dehaze_24) //뒤로가기 버튼의 아이콘을 변경


        tab_layout.addTab(tab_layout.newTab().setText("제어정보"))
        tab_layout.addTab(tab_layout.newTab().setText("상태정보"))
        tab_layout.addTab(tab_layout.newTab().setText("정책정보"))

        fragList = arrayListOf(
            FragmentControl(), FragmentState() , FragmentPolicy()
        )


        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        //프래그먼트 매니저에서 트랜잭션 객체 생성(각종 트랜잭션 작업들(추가, 삭제, 교체 등) 가능)
        for(i in 0 until fragList.size){
            transaction.add(R.id.main_frame,fragList[i])
            transaction.hide(fragList[i])
        }
        transaction.show(fragList[0]).commit()

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null){ changeFrag(tab.position) }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
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

    fun changeFrag(position : Int){
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        for (i in 0 until fragList.size){ transaction.hide(fragList[i]) }
        transaction.show(fragList[position]).commit()
    }
}