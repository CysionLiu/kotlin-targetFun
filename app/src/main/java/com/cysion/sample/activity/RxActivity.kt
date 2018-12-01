package com.cysion.sample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cysion.other.addTo
import com.cysion.sample.R
import com.cysion.sample.logd
import com.cysion.targetfun._subscribe
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_rx.*
import java.util.concurrent.TimeUnit

class RxActivity : AppCompatActivity() {

    val cd = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx)

        btnOpen1.setOnClickListener {
            Observable.just("1", "2", "3", "4", "5")
                ._subscribe {
                    _onNext {
                        tvShow1.append("$it - ")
                    }
                    _onComplete {
                        logd("on complete")
                    }
                }.addTo(cd)
        }

        btnOpen2.setOnClickListener {
            Observable.interval(1, TimeUnit.SECONDS)
                .map {
                    Tmp("demo", it.toInt())
                }
                .observeOn(AndroidSchedulers.mainThread())
                ._subscribe {
                    _onNext {
                        tvShow2.append(" * ${it.age}")
                    }
                    _onError {
                        logd("_onerror")
                    }
                }.addTo(cd)

        }

        btnOpen3.setOnClickListener {
            Flowable.create(object : FlowableOnSubscribe<String> {
                override fun subscribe(emitter: FlowableEmitter<String>) {
                    emitter.onNext("flow1")
                    emitter.onNext("flow2")
                    emitter.onNext("flow3")
                    emitter.onNext("flow4")
                    emitter.onComplete()
                }
            }, BackpressureStrategy.MISSING)
                ._subscribe {
                    _onNext {
                        logd("flowable--$it")
                    }
                    _onComplete {
                        logd("flowable complete")
                    }
                }
        }

        btnclose.setOnClickListener {
            cd.clear()
        }
    }
}

data class Tmp(var name: String, var age: Int)