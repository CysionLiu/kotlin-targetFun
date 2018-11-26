package com.cysion.other

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.EditText


inline fun <reified T : Activity> Activity.startActivity_ex() {
    val i = Intent(this, T::class.java)
    startActivity(i)
}

inline fun <reified T : Activity> Activity.startActivity_ex(key: String, bundle: Bundle) {
    val i = Intent(this, T::class.java)
    i.putExtra(key, bundle)
    startActivity(i)
}

//only available on true device
fun EditText.openKeyBoard() {
    val imm = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.RESULT_SHOWN)
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
}

fun EditText.hideKeyBoard() {
    val imm = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}
