package com.cysion.targetfun

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class ObserverObj<T> : Observer<T> {

    private var _a: ((disposable: Disposable) -> Unit)? = null
    private var _b: ((t: T) -> Unit)? = null
    private var _c: (() -> Unit)? = null
    private var _d: ((e: Throwable) -> Unit)? = null

    //===
    fun _onSubscribe(t: ((disposable: Disposable) -> Unit)) {
        _a = t
    }

    override fun onSubscribe(d: Disposable) {
        _a?.invoke(d)
    }


    //===
    fun _onNext(t: ((t: T) -> Unit)) {
        _b = t
    }

    override fun onNext(t: T) {
        _b?.invoke(t)
    }

    //===
    fun _onComplete(t: (() -> Unit)) {
        _c = t
    }

    override fun onComplete() {
        _c?.invoke()
    }


    //===
    fun _onError(t: ((e: Throwable) -> Unit)) {
        _d = t
    }

    override fun onError(e: Throwable) {
        _d?.invoke(e)
    }
}

inline fun <reified T> Observable<T>._subscribe(func: ObserverObj<T>.() -> Unit) =
    subscribe(ObserverObj<T>().apply(func))