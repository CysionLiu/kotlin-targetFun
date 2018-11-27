package com.cysion.targetfun

import android.animation.Animator
import android.view.ViewPropertyAnimator

class AnimatorListenerObj : Animator.AnimatorListener {

    //-----------------
    private var _a: ((animation: Animator?) -> Unit)? = null

    fun onAnimationRepeat_ex(t: ((animation: Animator?) -> Unit)) {
        _a = t
    }

    override fun onAnimationRepeat(animation: Animator?) {
        _a?.invoke(animation)
    }

    //------------------
    private var _b: ((animation: Animator?) -> Unit)? = null

    fun onAnimationEnd_ex(t: ((animation: Animator?) -> Unit)) {
        _b = t
    }

    override fun onAnimationEnd(animation: Animator?) {
        _b?.invoke(animation)
    }

    //--------------------
    private var _c: ((animation: Animator?) -> Unit)? = null

    fun onAnimationCancel_ex(t: ((animation: Animator?) -> Unit)) {
        _c = t
    }

    override fun onAnimationCancel(animation: Animator?) {
        _c?.invoke(animation)
    }

    //---------------------
    private var _d: ((animation: Animator?) -> Unit)? = null

    fun onAnimationStart_ex(t: ((animation: Animator?) -> Unit)) {
        _d = t
    }

    override fun onAnimationStart(animation: Animator?) {
        _d?.invoke(animation)
    }
}

inline fun ViewPropertyAnimator.setListener(func: (AnimatorListenerObj.() -> Unit)) =
    setListener(AnimatorListenerObj().apply(func))

inline fun Animator.addListener(func: (AnimatorListenerObj.() -> Unit)) =
    addListener(AnimatorListenerObj().apply(func))
