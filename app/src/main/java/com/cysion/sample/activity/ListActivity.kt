package com.cysion.sample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.cysion.sample.R
import com.cysion.sample.logd
import com.cysion.targetfun.setOnScrollListener
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.item_main_list.view.*

class ListActivity : AppCompatActivity() {

    var datalist = listOf<String>(
        "one", "two", "three", "one2", "two2", "three2",
        "one3", "two3", "three3", "one4", "two4", "three4", "one5", "two5", "three5"
        , "one6", "two6", "three6"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        listView.adapter = object : BaseAdapter() {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val view: View
                view = LayoutInflater.from(this@ListActivity).inflate(R.layout.item_main_list, parent, false)
                view.tvName.text = datalist[position]
                return view
            }

            override fun getItem(position: Int): Any {
                return datalist[position]
            }

            override fun getItemId(position: Int): Long {
                return position.toLong()
            }

            override fun getCount(): Int {
                return datalist.size

            }

        }

        //also available for gridview
        listView.setOnScrollListener {
            onScroll_ex { view, firstVisibleItem, visibleItemCount, totalItemCount ->
                logd("firstVisibleItem:$firstVisibleItem,visibleItemCount:$visibleItemCount")
            }
        }
    }
}
