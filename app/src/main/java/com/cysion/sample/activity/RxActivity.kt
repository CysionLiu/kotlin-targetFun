package com.cysion.sample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cysion.other.addTo
import com.cysion.sample.R
import com.cysion.sample.logd
import com.cysion.sample.logi
import com.cysion.targetfun._subscribe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_rx.*
import java.util.concurrent.TimeUnit

class RxActivity : AppCompatActivity() {

    val com = CompositeDisposable()
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
                }
                .addTo(com)
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
                }
                .addTo(com)
        }

        btnOpen3.setOnClickListener {
            Observable.just(1, 2)
                .concatMap {
                    if(it==1){
                        Observable.just(it).delay(5,TimeUnit.SECONDS)
                    }else{
                        Observable.just(it).delay(2,TimeUnit.SECONDS)
                    }
                }
                .observeOn(AndroidSchedulers.mainThread())
                ._subscribe {
                    _onNext {
                        tvShow3.append(" * ${it}")
                    }
                    _onError {
                        logi("_ error__")
                    }
                }.addTo(com)
        }

        btnclose.setOnClickListener {
            com.clear()
        }

    }
}

data class Tmp(var name: String, var age: Int)