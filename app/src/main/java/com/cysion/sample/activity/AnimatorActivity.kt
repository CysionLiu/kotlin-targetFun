package com.cysion.sample.activity

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cysion.sample.R
import com.cysion.sample.logd
import com.cysion.targetfun.withListener
import kotlinx.android.synthetic.main.activity_animator.*

class AnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator)
        btnStart1.setOnClickListener { view ->
            ObjectAnimator.ofFloat(img1, "rotationX", 0f, 270f, 0f)
                .apply {
                    duration = 3000
                    repeatCount = 3
                    withListener {
                        ifStart {
                            logd("-------img1 start")
                        }
                        ifEnd {
                            logd("-------img1 end")
                        }
                        ifRepeat {
                            logd("------img1 repeat")
                        }
                    }
                }.start()
        }
        btnStart2.setOnClickListener { view ->
            img2.animate()
                .apply {
                    rotationBy(720f)
                    duration = 3000
                    withListener {
                        ifStart {
                            logd("-------img2 start")
                        }
                        ifEnd {
                            logd("------img2 end")
                        }
                    }
                }.start()
        }
    }
}
