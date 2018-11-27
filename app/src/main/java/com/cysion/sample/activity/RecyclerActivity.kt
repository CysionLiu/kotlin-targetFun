package com.cysion.sample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.cysion.sample.R
import com.cysion.sample.adapter.SimpleAdapter
import com.cysion.sample.logd
import com.cysion.sample.logi
import com.cysion.targetfun.addOnItemTouchListener
import com.cysion.targetfun.addOnScrollListener
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SimpleAdapter(
            arrayListOf(
                "one", "two", "three", "one2", "two2", "three2",
                "one3", "two3", "three3", "one4", "two4", "three4", "one5", "two5", "three5"
                , "one6", "two6", "three6"
            )
        )

        recyclerView.addOnScrollListener {
            onScrollStateChanged_ex { recyclerView, newState ->
                logd("newstate:$newState")
            }
        }

        recyclerView.addOnItemTouchListener {
            onInterceptTouchEvent_ex { rv, e ->
                logi("e.rawY:${e?.rawY}")
                false
            }
        }
    }
}
