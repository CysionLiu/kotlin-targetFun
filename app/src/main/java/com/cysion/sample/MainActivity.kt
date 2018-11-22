package com.cysion.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.cysion.targetfun.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

fun logf(msg: String) {
    Log.i("flag---", msg)
}
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et1.addTextChangedListener {
            _beforeTextChanged { s, start, count, after ->
                logf("(MainActivity.kt:16)---->>s:$s,start:$start,count:$count");
            }
            _onTextChanged { s, start, before, count ->
                logf("(MainActivity.kt:19)---->>s:$s,start:$start,count:$count");
            }
        }
        et2.addTextChangedListener {
            _afterTextChanged {
                logf("(MainActivity.kt:24)---->>${it?.toString()}");
            }

        }
    }
}
