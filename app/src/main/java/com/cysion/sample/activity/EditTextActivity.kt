package com.cysion.sample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cysion.sample.R
import com.cysion.sample.log
import com.cysion.targetfun.addTextChangedListener
import kotlinx.android.synthetic.main.activity_edittext.*

class EditTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edittext)

        et1.addTextChangedListener {
            _onTextChanged { s, start, before, count ->
                tvShow.text = "_onTextChanged:$s"
                log("_onTextChanged:$s")
            }
        }
        et2.addTextChangedListener {
            _beforeTextChanged { s, start, count, after ->
                log("_beforeTextChanged:$s")
            }
            _afterTextChanged {
                tvShow.text = "_afterTextChanged:${it.toString()}"
                log("_afterTextChanged:${it.toString()}")
            }
        }
        et3.addTextChangedListener {
            _beforeTextChanged { s, start, count, after ->
                log("_beforeTextChanged:$s")
            }
            _onTextChanged { s, start, before, count ->
                log("_onTextChanged:$s")
            }
            _afterTextChanged {
                tvShow.text = "_afterTextChanged:${it.toString()}"
                log("_afterTextChanged:${it.toString()}")
            }
        }
    }
}
