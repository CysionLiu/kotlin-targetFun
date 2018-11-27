package com.cysion.sample.activity

import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cysion.sample.R
import com.cysion.sample.logd
import com.cysion.sample.logi
import com.cysion.targetfun.addOnAttachStateChangeListener_ex
import com.cysion.targetfun.addOnPageChangeListener
import kotlinx.android.synthetic.main.activity_viewpager.*

class ViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)
        viewPager.apply {
            adapter = MyAdapter()
            addOnPageChangeListener {
                onPageSelected_ex {
                    tvShow.text = "select page $it"
                    logi("listener:${this.toString()}")
                }
                onPageScrolled_ex { position, positionOffset, positionOffsetPixels ->
                    logd("position:$position, positionOffset:$positionOffset")
                }
            }
            //add another listener
            addOnPageChangeListener {
                onPageScrollStateChanged_ex {
                    logd("state:$it")
                    logi("listener:${this.toString()}")
                }
            }
        }
    }
}

private class MyAdapter() : PagerAdapter() {
    val arr = listOf<String>("page1", "page2", "page3")
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return arr.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var textview = TextView(container.context)
        textview.text = arr[position]
        container.addView(textview)
        return textview
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}