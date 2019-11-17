package com.cysion.targetfun

import android.view.View

class AttachStateChangeListenerObj : View.OnAttachStateChangeListener {

    //-------------------------------------------------
    private var _a: ((v: View?) -> Unit)? = null

    fun ifDetached(t: ((v: View?) -> Unit)) {
        _a = t
    }

    override fun onViewDetachedFromWindow(v: View?) {
        _a?.invoke(v)
    }

    //----------------------------------------------------
    private var _b: ((v: View?) -> Unit)? = null

    fun ifAttached(t: ((v: View?) -> Unit)) {
        _b = t
    }

    override fun onViewAttachedToWindow(v: View?) {
        _b?.invoke(v)
    }
}

inline fun View.withAttachStateChangeListener(func: (AttachStateChangeListenerObj.() -> Unit)) =
    addOnAttachStateChangeListener(AttachStateChangeListenerObj().apply(func))
