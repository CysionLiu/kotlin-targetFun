package com.cysion.sample.activity

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cysion.sample.R
import com.cysion.sample.logd
import com.cysion.targetfun._addListener
import com.cysion.targetfun._setListener
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
                    _addListener {
                        _onAnimationStart {
                            logd("-------img1 start")
                        }
                        _onAnimationEnd {
                            logd("-------img1 end")
                        }
                        _onAnimationRepeat {
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
                    _setListener {
                        _onAnimationStart {
                            logd("-------img2 start")
                        }
                        _onAnimationEnd {
                            logd("------img2 end")
                        }
                    }
                }.start()
        }
    }
}
