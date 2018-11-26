package com.cysion.sample.activity.other

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cysion.other.hideKeyBoard
import com.cysion.other.openKeyBoard
import com.cysion.sample.R
import kotlinx.android.synthetic.main.activity_edit_ex.*

class EditExActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_ex)
        //only available on true device
        btnOpen.setOnClickListener {
            etShow.openKeyBoard()
        }
        btnHide.setOnClickListener {
            etShow.hideKeyBoard()
        }
    }
}
