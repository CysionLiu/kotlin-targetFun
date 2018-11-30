package com.cysion.sample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cysion.sample.R
import com.cysion.sample.logd
import com.cysion.sample.logi
import com.cysion.targetfun._setOnSeekBarChangeListener
import kotlinx.android.synthetic.main.activity_seekbar.*

class SeekBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seekbar)

        //the original style
//        seekbar._setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//        })
        seekbar._setOnSeekBarChangeListener {
            _onStartTouch {
                logd("start touch")
            }

            _onProgressChanged { seekBar, progress, fromUser ->
                logd("progress:$progress")
            }
        }

        appcompatSeekBar._setOnSeekBarChangeListener {
            _onProgressChanged { seekBar, progress, fromUser ->
                logi("progress:$progress")
            }
            _onStopTouch {
                logi("appcompat stop touch，progress:${it?.progress}")
            }
        }

    }
}
