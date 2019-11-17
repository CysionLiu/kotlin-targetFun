package com.cysion.sample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import com.cysion.other.clickWithLimit
import com.cysion.sample.R
import com.cysion.sample.logd
import com.cysion.targetfun.withDrawerListener
import kotlinx.android.synthetic.main.activity_drawer.*

class DrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

        btnOpen.clickWithLimit {
            drawer.openDrawer(Gravity.RIGHT)
        }

        drawer.withDrawerListener {
            ifOpened {
                logd("opened")
            }
            ifClosed {
                logd("closed")
            }
            ifStateChanged {
                logd("newstate:$it")
            }
        }
    }
}
