package com.cysion.sample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cysion.sample.R
import com.cysion.sample.logd
import com.cysion.targetfun.withTextChangedListener
import kotlinx.android.synthetic.main.activity_edittext.*

class EditTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edittext)

        et1.withTextChangedListener {
            ifTextChanged { s, start, before, count ->
                tvShow.text = "ifTextChanged:$s"
                logd("ifTextChanged:$s")
            }
        }

        et2.withTextChangedListener {
            ifBeforeTextChanged { s, start, count, after ->
                logd("ifBeforeTextChanged:$s")
            }
            ifAfterTextChanged {
                tvShow.text = "ifAfterTextChanged:${it.toString()}"
                logd("ifAfterTextChanged:${it.toString()}")
            }
        }

        et3.withTextChangedListener {
            ifBeforeTextChanged { s, start, count, after ->
                logd("ifBeforeTextChanged:$s")
            }
            ifTextChanged { s, start, before, count ->
                logd("ifTextChanged:$s")
            }
            ifAfterTextChanged {
                tvShow.text = "ifAfterTextChanged:${it.toString()}"
                logd("ifAfterTextChanged:${it.toString()}")
            }
        }
    }
}
