package com.cysion.targetfun

import android.support.v4.widget.DrawerLayout
import android.view.View


class DrawerListenerObj : DrawerLayout.DrawerListener {

    private var _a: ((newState: Int) -> Unit)? = null


    override fun onDrawerStateChanged(newState: Int) {
    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
    }

    override fun onDrawerClosed(drawerView: View) {
    }

    override fun onDrawerOpened(drawerView: View) {
    }

}

inline fun DrawerLayout.ad(func: DrawerListenerObj.() -> Unit) {
    addDrawerListener(DrawerListenerObj().apply(func))
}