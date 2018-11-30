package com.cysion.sample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cysion.sample.R
import com.cysion.sample.logd
import com.cysion.targetfun._addTextChangedListener
import kotlinx.android.synthetic.main.activity_edittext.*

class EditTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edittext)

        et1._addTextChangedListener {
            _onTextChanged { s, start, before, count ->
                tvShow.text = "_onTextChanged:$s"
                logd("_onTextChanged:$s")
            }
        }

        et2._addTextChangedListener {
            _beforeTextChanged { s, start, count, after ->
                logd("_beforeTextChanged:$s")
            }
            _afterTextChanged {
                tvShow.text = "_afterTextChanged:${it.toString()}"
                logd("_afterTextChanged:${it.toString()}")
            }
        }

        et3._addTextChangedListener {
            _beforeTextChanged { s, start, count, after ->
                logd("_beforeTextChanged:$s")
            }
            _onTextChanged { s, start, before, count ->
                logd("_onTextChanged:$s")
            }
            _afterTextChanged {
                tvShow.text = "_afterTextChanged:${it.toString()}"
                logd("_afterTextChanged:${it.toString()}")
            }
        }
    }
}
