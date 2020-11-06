package com.example.mdm.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mdm.GridAdapter
import com.example.mdm.Item
import com.example.mdm.R
import kotlinx.android.synthetic.main.fragment_control.view.*


class FragmentControl : Fragment(){

    var dataList : ArrayList<Item> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_control, container, false) as ViewGroup

        dataList.add(Item("Camera", true))
        dataList.add(Item("Screenshot", false))
        dataList.add(Item("Browser", true))
        dataList.add(Item("3G/LTE", true))
        dataList.add(Item("WiFi", false))
        dataList.add(Item("Bluetooth", false))

        dataList.add(Item("GPS", true))
        dataList.add(Item("Mic", true))
        dataList.add(Item("Tethering", false))
        dataList.add(Item("USB", true))
        dataList.add(Item("NFC", false))
        dataList.add(Item("SDCard", false))

        dataList.add(Item("OTA Update", true))
        dataList.add(Item("Factory Reset", true))
        dataList.add(Item("Time Change", false))

        val mRecycler : RecyclerView = rootView.recycler_view
        val mGridAdapter = GridAdapter(dataList)
        mRecycler.layoutManager = GridLayoutManager(activity, 2)



        mRecycler.adapter = mGridAdapter
        return rootView
    }
}