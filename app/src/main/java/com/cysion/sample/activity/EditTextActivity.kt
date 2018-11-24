package com.cysion.sample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cysion.sample.R
import com.cysion.sample.logd
import com.cysion.targetfun.addTextChangedListener
import kotlinx.android.synthetic.main.activity_edittext.*

class EditTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edittext)

        et1.addTextChangedListener {
            onTextChanged_ex { s, start, before, count ->
                tvShow.text = "onTextChanged_ex:$s"
                logd("onTextChanged_ex:$s")
            }
        }
        et2.addTextChangedListener {
            beforeTextChanged_ex { s, start, count, after ->
                logd("beforeTextChanged_ex:$s")
            }
            afterTextChanged_ex {
                tvShow.text = "afterTextChanged_ex:${it.toString()}"
                logd("afterTextChanged_ex:${it.toString()}")
            }
        }
        et3.addTextChangedListener {
            beforeTextChanged_ex { s, start, count, after ->
                logd("beforeTextChanged_ex:$s")
            }
            onTextChanged_ex { s, start, before, count ->
                logd("onTextChanged_ex:$s")
            }
            afterTextChanged_ex {
                tvShow.text = "afterTextChanged_ex:${it.toString()}"
                logd("afterTextChanged_ex:${it.toString()}")
            }
        }
    }
}
