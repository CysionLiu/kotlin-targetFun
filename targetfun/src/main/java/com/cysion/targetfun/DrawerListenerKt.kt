package com.cysion.targetfun

import android.support.v4.widget.DrawerLayout
import android.view.View


class DrawerListenerObj : DrawerLayout.DrawerListener {

    //--------------------------------------------------
    private var _a: ((newState: Int) -> Unit)? = null

    fun _onDrawerStateChanged(t: ((newState: Int) -> Unit)) {
        _a = t
    }

    override fun onDrawerStateChanged(newState: Int) {
        _a?.invoke(newState)
    }

    //--------------------------------------------------
    private var _b: ((drawerView: View, slideOffset: Float) -> Unit)? = null

    fun _onDrawerSlide(t: ((drawerView: View, slideOffset: Float) -> Unit)) {
        _b = t
    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        _b?.invoke(drawerView, slideOffset)
    }


    //--------------------------------------------------
    private var _c: ((drawerView: View) -> Unit)? = null

    fun _onDrawerClosed(t: ((drawerView: View) -> Unit)) {
        _c = t
    }

    override fun onDrawerClosed(drawerView: View) {
        _c?.invoke(drawerView)
    }


    //--------------------------------------------------
    private var _d: ((drawerView: View) -> Unit)? = null

    fun _onDrawerOpened(t: ((drawerView: View) -> Unit)) {
        _d = t
    }

    override fun onDrawerOpened(drawerView: View) {
        _d?.invoke(drawerView)
    }

}

inline fun DrawerLayout._addDrawerListener(func: DrawerListenerObj.() -> Unit) {
    addDrawerListener(DrawerListenerObj().apply(func))
}