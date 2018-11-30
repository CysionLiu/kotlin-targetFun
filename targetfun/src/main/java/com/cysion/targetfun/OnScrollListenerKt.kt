package com.cysion.targetfun

import android.widget.AbsListView

class OnScrollListenerObj : AbsListView.OnScrollListener {
    //------------------------------
    private var _a: ((view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) -> Unit)? =
        null

    fun _onScroll(t: ((view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) -> Unit)) {
        _a = t
    }

    override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
        _a?.invoke(view, firstVisibleItem, visibleItemCount, totalItemCount)
    }

    //-------------------------------
    private var _b: ((view: AbsListView?, scrollState: Int) -> Unit)? =
        null

    fun _onScrollStateChanged(t: ((view: AbsListView?, scrollState: Int) -> Unit)) {
        _b = t
    }

    override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {
        _b?.invoke(view, scrollState)
    }
}

//also available for gridview
inline fun AbsListView._setOnScrollListener(func: (OnScrollListenerObj.() -> Unit)) =
    setOnScrollListener(OnScrollListenerObj().apply(func))
