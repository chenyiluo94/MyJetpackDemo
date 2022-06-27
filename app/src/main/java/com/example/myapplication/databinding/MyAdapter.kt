package com.example.myapplication.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MyAdapter:RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    private val adapterInfo=ArrayList<AdapterInfo>()
    init {
        for (i in 1..10 ){
            adapterInfo.add(AdapterInfo("这是我的数据${i}"))
        }
    }
    inner class MyViewHolder(var layoutItemDatabindingBinding: LayoutItemDatabindingBinding) : RecyclerView.ViewHolder(layoutItemDatabindingBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {

        val binding=DataBindingUtil.inflate<LayoutItemDatabindingBinding>(LayoutInflater.from(parent.context), R.layout.layout_item_databinding,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.layoutItemDatabindingBinding.adapterInfo=adapterInfo[position]

    }

    override fun getItemCount(): Int {
        return adapterInfo.size
    }
}