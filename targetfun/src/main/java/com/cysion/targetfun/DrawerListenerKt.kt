package com.cysion.targetfun

import android.support.v4.widget.DrawerLayout
import android.view.View


class DrawerListenerObj : DrawerLayout.DrawerListener {

    //--------------------------------------------------
    private var _a: ((newState: Int) -> Unit)? = null

    fun ifStateChanged(t: ((newState: Int) -> Unit)) {
        _a = t
    }

    override fun onDrawerStateChanged(newState: Int) {
        _a?.invoke(newState)
    }

    //--------------------------------------------------
    private var _b: ((drawerView: View, slideOffset: Float) -> Unit)? = null

    fun ifSlide(t: ((drawerView: View, slideOffset: Float) -> Unit)) {
        _b = t
    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        _b?.invoke(drawerView, slideOffset)
    }


    //--------------------------------------------------
    private var _c: ((drawerView: View) -> Unit)? = null

    fun ifClosed(t: ((drawerView: View) -> Unit)) {
        _c = t
    }

    override fun onDrawerClosed(drawerView: View) {
        _c?.invoke(drawerView)
    }


    //--------------------------------------------------
    private var _d: ((drawerView: View) -> Unit)? = null

    fun ifOpened(t: ((drawerView: View) -> Unit)) {
        _d = t
    }

    override fun onDrawerOpened(drawerView: View) {
        _d?.invoke(drawerView)
    }

}

inline fun DrawerLayout.withDrawerListener(func: DrawerListenerObj.() -> Unit) =
    addDrawerListener(DrawerListenerObj().apply(func))
