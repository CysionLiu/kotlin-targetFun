package com.cysion.targetfun

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class TextWatcherObj : TextWatcher {

    //---
    private var _afterTextChanged: ((s: Editable?) -> Unit)? = null

    fun ifAfterTextChanged(func: ((s: Editable?) -> Unit)) {
        _afterTextChanged = func
    }

    override fun afterTextChanged(s: Editable?) {
        _afterTextChanged?.invoke(s)
    }

    //---
    private var _beforeTextChanged: ((s: CharSequence?, start: Int, count: Int, after: Int) -> Unit)? = null

    fun ifBeforeTextChanged(func: ((s: CharSequence?, start: Int, count: Int, after: Int) -> Unit)) {
        _beforeTextChanged = func
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        _beforeTextChanged?.invoke(s, start, count, after)
    }


    //---
    private var _onTextChanged: ((s: CharSequence?, start: Int, before: Int, count: Int) -> Unit)? = null

    fun ifTextChanged(func: ((s: CharSequence?, start: Int, before: Int, count: Int) -> Unit)) {
        _onTextChanged = func
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        _onTextChanged?.invoke(s, start, before, count)
    }
}
inline fun EditText.withTextChangedListener(func: (TextWatcherObj.() -> Unit))=
    addTextChangedListener(TextWatcherObj().apply(func))
