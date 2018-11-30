package com.cysion.sample.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cysion.other._setOnClickListener
import com.cysion.other.startActivityForResult_ex
import com.cysion.other.timeFormatm
import com.cysion.sample.R
import com.cysion.sample.activity.other.EditExActivity
import com.cysion.sample.logd
import com.cysion.sample.logi
import com.cysion.targetfun._addOnAttachStateChangeListener
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        btnEditEx.setOnClickListener {
            startActivityForResult_ex<EditExActivity>(1000)
        }

        btnFilter._setOnClickListener {
            logd("clicked--" + System.currentTimeMillis().timeFormatm(""))
        }

        btnFilter._addOnAttachStateChangeListener {
            _onAttached {
                logd("btnFilter attached")
            }
            _onDetached {
                logd("btnFilter detached")
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        logi("requestCode:$requestCode")
    }
}
