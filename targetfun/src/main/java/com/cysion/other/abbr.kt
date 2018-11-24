package com.cysion.other

import android.app.Activity
import android.content.Intent


inline fun <reified T : Activity> Activity.startActivity() {
    var i = Intent(this, T::class.java)
    startActivity(i)
}