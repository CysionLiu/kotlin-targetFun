package com.cysion.targetfun

import android.widget.SeekBar

class SeekBarChangeListenerObj : SeekBar.OnSeekBarChangeListener {

    //----------------------------------------------
    private var _a: ((seekBar: SeekBar?, progress: Int, fromUser: Boolean) -> Unit)? = null

    fun _onProgressChanged(t: ((seekBar: SeekBar?, progress: Int, fromUser: Boolean) -> Unit)) {
        _a = t
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        _a?.invoke(seekBar, progress, fromUser)
    }

    //----------------------------------------------
    private var _b: ((seekBar: SeekBar?) -> Unit)? = null

    fun _onStartTouch(t: ((seekBar: SeekBar?) -> Unit)) {
        _b = t
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        _b?.invoke(seekBar)
    }


    //----------------------------------------------
    private var _c: ((seekBar: SeekBar?) -> Unit)? = null

    fun _onStopTouch(t: ((seekBar: SeekBar?) -> Unit)) {
        _c = t
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        _c?.invoke(seekBar)
    }

}

inline fun SeekBar._setOnSeekBarChangeListener(func: (SeekBarChangeListenerObj.() -> Unit)) =
    setOnSeekBarChangeListener(SeekBarChangeListenerObj().apply(func))
