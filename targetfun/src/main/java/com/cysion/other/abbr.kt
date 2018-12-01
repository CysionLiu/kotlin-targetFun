package com.cysion.other

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import java.text.SimpleDateFormat


inline fun <reified T : Activity> Activity._startActivity() {
    val i = Intent(this, T::class.java)
    startActivity(i)
}

inline fun <reified T : Activity> Activity._startActivityForResult(requestcode: Int) {
    val i = Intent(this, T::class.java)
    startActivityForResult(i, requestcode)
}

inline fun <reified T : Activity> Activity._startActivity(key: String, bundle: Bundle) {
    val i = Intent(this, T::class.java)
    i.putExtra(key, bundle)
    startActivity(i)
}

inline fun <reified T : Activity> Activity._startActivityForResult(key: String, bundle: Bundle, requestcode: Int) {
    val i = Intent(this, T::class.java)
    i.putExtra(key, bundle)
    startActivityForResult(i, requestcode)
}

//may only available on real device
fun EditText.openKeyBoard() {
    val imm = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.RESULT_SHOWN)
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
}

//may only available on real device
fun EditText.hideKeyBoard() {
    val imm = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

//filter frequent click event
fun View._setOnClickListener(block: ((v: View?) -> Unit)) {
    setOnClickListener(object : View.OnClickListener {
        var last = 0L
        override fun onClick(v: View?) {
            if (System.currentTimeMillis() - last > 500) {
                block(v)
                last = System.currentTimeMillis()
            }
        }
    })
}
fun View._setOnClickListener(intervalMill:Int,block: ((v: View?) -> Unit)) {
    setOnClickListener(object : View.OnClickListener {
        var last = 0L
        override fun onClick(v: View?) {
            if (System.currentTimeMillis() - last > intervalMill) {
                block(v)
                last = System.currentTimeMillis()
            }
        }
    })
}

fun Context.density(): Float {
    return resources.displayMetrics.density
}

//======================================================
fun Context.dp2px(x: Int): Float {
    return density() * x
}

fun View.dp2px(x: Int): Float {
    return context.density() * x
}

fun Fragment.dp2px(x: Int): Float {
    return activity.density() * x
}

//-----------------------------------------------------
fun Context.px2dp(x: Float): Float {
    return x / density()
}

fun View.px2dp(x: Float): Float {
    return x / context.density()
}

fun Fragment.px2dp(x: Float): Float {
    return x / activity.density()
}

//=======================================================
fun Context.str(@StringRes resid: Int): String {
    return resources.getString(resid)
}

fun Context.color(@ColorRes resid: Int): Int {
    return resources.getColor(resid)
}

fun Context.drawable(@DrawableRes resid: Int): Drawable {
    return resources.getDrawable(resid)
}

fun View.str(@StringRes resid: Int): String {
    return resources.getString(resid)
}

fun View.color(@ColorRes resid: Int): Int {
    return resources.getColor(resid)
}

fun View.drawable(@DrawableRes resid: Int): Drawable {
    return resources.getDrawable(resid)
}

/*

//regex,eg:"yyyy-MM-dd HH:mm:ss",if null or "" ,use "yyyy-MM-dd HH:mm:ss";
unit is second
 */
fun Long.timeFormat(regex: String): String {
    var f = regex
    if (TextUtils.isEmpty(regex)) {
        f = "yyyy-MM-dd HH:mm:ss";
    }
    return SimpleDateFormat(f).format(this * 1000)
}

/*
//regex,eg:"yyyy-MM-dd HH:mm:ss",if null or "" ,use "yyyy-MM-dd HH:mm:ss";
unit is millisecond
 */
fun Long.timeFormatm(regex: String): String {
    var f = regex
    if (TextUtils.isEmpty(regex)) {
        f = "yyyy-MM-dd HH:mm:ss";
    }
    return SimpleDateFormat(f).format(this)
}
