package com.cysion.sample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import com.cysion.other.setOnClickListener_ex
import com.cysion.other.str
import com.cysion.sample.R
import com.cysion.sample.logd
import com.cysion.targetfun.addDrawerListener
import kotlinx.android.synthetic.main.activity_drawer.*

class DrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

        btnOpen.setOnClickListener_ex {
            drawer.openDrawer(Gravity.RIGHT)
        }

        drawer.addDrawerListener {
            onDrawerOpened_ex {
                logd("opened")
            }
            onDrawerClosed_ex {
                logd("closed")
            }
            onDrawerSlide_ex { drawerView, slideOffset ->
                logd("slide:${this@DrawerActivity.str(R.string.app_name)}")
            }
            onDrawerStateChanged_ex {
                logd("newstate:$it")
            }
        }
    }
}
