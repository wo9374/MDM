package com.example.mdm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*


data class Item(var txt: String, var choice: Boolean)

class ControlAdapter(list: ArrayList<Item>) : RecyclerView.Adapter<ControlAdapter.ViewHolder>(){

    var itemData: ArrayList<Item> = list
    var onItemCheckedListener: OnCheckedChangeListener? = null

    //스위치 버튼 리스너
    val mOnCheckedChangeListener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
        val position = buttonView.tag as Int  //onBindViewHolder에서 태그에 set해준 position을 get
        if (onItemCheckedListener != null) { onItemCheckedListener!!.onCheckedChanged(position, isChecked) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data : Item = itemData[position]
        holder.item_txt.text = data.txt
        holder.switch_btn.tag = position //태그에 position set
        holder.switch_btn.isChecked = data.choice
        holder.switch_btn.setOnCheckedChangeListener(mOnCheckedChangeListener)
    }

    override fun getItemCount(): Int {
        return  itemData.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var item_txt : TextView = itemView.item_txt
        var switch_btn : Switch = itemView.switch_btn
    }

    interface OnCheckedChangeListener {
        fun onCheckedChanged(position: Int, isChecked: Boolean)
    }
    
    //OnCheckedChangeListener 리스너 객체 참조를 어댑터에 전달하는 메소드
    fun setOnCheckedChangeListener(listener: OnCheckedChangeListener) {
        onItemCheckedListener = listener
    }
}