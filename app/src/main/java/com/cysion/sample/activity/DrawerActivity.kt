package com.cysion.sample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import com.cysion.other._setOnClickListener
import com.cysion.sample.R
import com.cysion.sample.logd
import com.cysion.targetfun._addDrawerListener
import kotlinx.android.synthetic.main.activity_drawer.*

class DrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

        btnOpen._setOnClickListener {
            drawer.openDrawer(Gravity.RIGHT)
        }

        drawer._addDrawerListener {
            _onDrawerOpened {
                logd("opened")
            }
            _onDrawerClosed {
                logd("closed")
            }
            _onDrawerStateChanged {
                logd("newstate:$it")
            }
        }
    }
}
