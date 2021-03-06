package com.cysion.targetfun

import io.reactivex.Flowable
import io.reactivex.FlowableSubscriber
import org.reactivestreams.Subscription

class FlowableObj<T> : FlowableSubscriber<T> {

    private var _a: ((s: Subscription) -> Unit)? = null
    private var _b: ((t: T) -> Unit)? = null
    private var _c: (() -> Unit)? = null
    private var _d: ((e: Throwable) -> Unit)? = null

    //===
    override fun onSubscribe(s: Subscription) {
        _a?.invoke(s)
    }

    fun ifSubscribe(t: ((s: Subscription) -> Unit)) {
        _a = t
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
}

inline fun <reified T> Flowable<T>.withSubscribe(func: FlowableObj<T>.() -> Unit) =
    subscribe(FlowableObj<T>().apply(func))