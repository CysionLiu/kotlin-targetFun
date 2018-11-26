package com.cysion.targetfun

import android.support.v7.widget.RecyclerView
import android.view.MotionEvent

class OnScrollListener : RecyclerView.OnScrollListener() {

    //---------------------------------
    private var _a: ((recyclerView: RecyclerView?, dx: Int, dy: Int) -> Unit)? = null

    fun onScrolled_ex(t: ((recyclerView: RecyclerView?, dx: Int, dy: Int) -> Unit)) {
        _a = t
    }

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        _a?.invoke(recyclerView, dx, dy)
    }

    //----------------------------------
    private var _b: ((recyclerView: RecyclerView?, newState: Int) -> Unit)? = null

    fun onScrollStateChanged_ex(t: ((recyclerView: RecyclerView?, newState: Int) -> Unit)) {
        _b = t
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
        _b?.invoke(recyclerView, newState)
    }
}



class OnItemTouchListenerObj : RecyclerView.OnItemTouchListener {

    //-------------------------------------
    private var _a: ((rv: RecyclerView?, e: MotionEvent?) -> Unit)? = null

    fun onTouchEvent_ex(t: ((rv: RecyclerView?, e: MotionEvent?) -> Unit)) {
        _a = t
    }

    override fun onTouchEvent(rv: RecyclerView?, e: MotionEvent?) {
        _a?.invoke(rv, e)
    }


    //-------------------------------------
    private var _b: ((rv: RecyclerView?, e: MotionEvent?) -> Boolean)? = null

    fun onInterceptTouchEvent_ex(t: ((rv: RecyclerView?, e: MotionEvent?) -> Boolean)) {
        _b = t
    }

    override fun onInterceptTouchEvent(rv: RecyclerView?, e: MotionEvent?): Boolean {
        if (_b == null) {
            return false
        }
        return _b!!.invoke(rv, e)
    }

    //-------------------------------------
    private var _c: ((disallowIntercept: Boolean) -> Unit)? = null

    fun onRequestDisallowInterceptTouchEvent_ex(t: ((disallowIntercept: Boolean) -> Unit)) {
        _c = t
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        _c?.invoke(disallowIntercept)
    }
}

inline fun RecyclerView.addOnScrollListener(func: (OnScrollListener.() -> Unit)) {
    val real = OnScrollListener()
    func.invoke(real)
    addOnScrollListener(real)
}

inline fun RecyclerView.addOnItemTouchListener(func: (OnItemTouchListenerObj.() -> Unit)) {
    val real = OnItemTouchListenerObj()
    func.invoke(real)
    addOnItemTouchListener(real)
}