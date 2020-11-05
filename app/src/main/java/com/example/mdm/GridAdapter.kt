package com.example.mdm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

data class Item(var txt: String, var choice: Boolean)

class GridAdapter(list: ArrayList<Item> ) : RecyclerView.Adapter<GridAdapter.ViewHolder>(){

    var itemData: ArrayList<Item> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data : Item = itemData[position]
        holder.item_txt.text = data.txt

        if (data.choice){
            holder.item_subtxt.text = "Allow"
        }
        else{
            holder.item_subtxt.text = "Deny"
        }

        holder.img_icon.isSelected = data.choice
        holder.item_subtxt.isSelected = data.choice
    }

    override fun getItemCount(): Int {
        return  itemData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var item_txt : TextView = itemView.item_txt
        var img_icon : ImageView = itemView.img_icon
        var item_subtxt : TextView = itemView.item_subtxt
    }
}