package com.cysion.sample.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cysion.sample.R
import kotlinx.android.synthetic.main.item_main_list.view.*

class SimpleAdapter(var datalist: ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return InnerHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main_list,parent,false))
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val h =holder as InnerHolder
        h.itemView.tvName.text=datalist[position]
    }
}

private class InnerHolder(root: View) : RecyclerView.ViewHolder(root)