package com.example.mdm

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.mdm.fragment.FragmentControl
import com.example.mdm.fragment.FragmentPolicy
import com.example.mdm.fragment.FragmentState
import kotlinx.android.synthetic.main.activity_floating_btn.*


class FloatingBtnActivity : AppCompatActivity(), View.OnClickListener {

    var fragList: ArrayList<Fragment> = ArrayList() //프래그먼트 리스트

    lateinit var fab_open: Animation
    lateinit var fab_close: Animation
    var openFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floating_btn)


        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false) //기본 타이틀 사용하지 않게 지정
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)   //뒤로가기 버튼 활성화
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_dehaze_24) //뒤로가기 버튼의 아이콘을 변경


        fab_open = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_open)
        fab_close = AnimationUtils.loadAnimation(applicationContext,R.anim.fab_close)

        fab_layout1.startAnimation(fab_close)
        fab_layout2.startAnimation(fab_close)
        fab_layout3.startAnimation(fab_close)

        fab_1.isClickable = false
        fab_2.isClickable = false
        fab_3.isClickable = false

        fab_main.setOnClickListener(this)
        fab_1.setOnClickListener(this)
        fab_2.setOnClickListener(this)
        fab_3.setOnClickListener(this)


        fragList = arrayListOf(FragmentControl(), FragmentState(), FragmentPolicy())

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        //프래그먼트 매니저에서 트랜잭션 객체 생성(각종 트랜잭션 작업들(추가, 삭제, 교체 등) 가능)
        for(i in 0 until fragList.size){
            transaction.add(R.id.fab_frame, fragList[i])
            transaction.hide(fragList[i])
        }
        transaction.show(fragList[0]).commit()
    }

    override fun onClick(v: View){
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        when(v.id){
            R.id.fab_main -> anim()
            R.id.fab_1 ->{
                anim()
                for (i in 0 until fragList.size) { transaction.hide(fragList[i])}
                transaction.show(fragList[0])
            }
            R.id.fab_2 -> {
                anim()
                for (i in 0 until fragList.size) { transaction.hide(fragList[i])}
                transaction.show(fragList[1])
            }
            R.id.fab_3 -> {
                anim()
                for (i in 0 until fragList.size) { transaction.hide(fragList[i])}
                transaction.show(fragList[2])
            }
        }
        transaction.commit()
    }

    fun anim(){
        if (openFlag){ //Fab이 눌려있을때 닫는 애니메이션
            sticker.visibility= View.GONE
            fab_layout1.startAnimation(fab_close)
            fab_layout2.startAnimation(fab_close)
            fab_layout3.startAnimation(fab_close)

            fab_1.isClickable = false
            fab_2.isClickable = false
            fab_3.isClickable = false
            openFlag = false
            
        }else{        //Fab이 눌리지 않았을 때 여는 애니메이션
            sticker.visibility= View.VISIBLE
            fab_layout1.startAnimation(fab_open)
            fab_layout2.startAnimation(fab_open)
            fab_layout3.startAnimation(fab_open)

            fab_1.isClickable = true
            fab_2.isClickable = true
            fab_3.isClickable = true
            openFlag = true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_action_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            //TODO 액션바 메뉴 id 판별해서 코드 실행
        }
        return super.onOptionsItemSelected(item)
    }
}