package com.cysion.targetfun

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class ObserverObj<T> : Observer<T> {

    private var _a: ((disposable: Disposable) -> Unit)? = null
    private var _b: ((t: T) -> Unit)? = null
    private var _c: (() -> Unit)? = null
    private var _d: ((e: Throwable) -> Unit)? = null
    private lateinit var disposable: Disposable

    //===
    fun ifSubscribe(t: ((disposable: Disposable) -> Unit)) {
        _a = t
    }

    override fun onSubscribe(d: Disposable) {
        disposable = d
        Log.i("opop",disposable.toString())
        _a?.invoke(d)
    }


    //===
    fun ifNext(t: ((t: T) -> Unit)) {
        _b = t
    }

    override fun onNext(t: T) {
        _b?.invoke(t)
    }

    //===
    fun ifComplete(t: (() -> Unit)) {
        _c = t
    }

    override fun onComplete() {
        _c?.invoke()
    }


    //===
    fun ifError(t: ((e: Throwable) -> Unit)) {
        _d = t
    }

    override fun onError(e: Throwable) {
        _d?.invoke(e)
    }

    fun getDisposable(): Disposable {
        return disposable
    }
}

inline fun <reified T> Observable<T>.withSubscribe(func: ObserverObj<T>.() -> Unit): Disposable {
    val real = ObserverObj<T>()
    real.func()
    subscribe(real)
    return real.getDisposable()
}
