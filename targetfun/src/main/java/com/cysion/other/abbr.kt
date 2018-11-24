package com.cysion.other

import android.app.Activity
import android.content.Intent
import android.os.Bundle


inline fun <reified T : Activity> Activity.startActivity_ex() {
    val i = Intent(this, T::class.java)
    startActivity(i)
}

inline fun <reified T : Activity> Activity.startActivity_ex(key: String, bundle: Bundle) {
    val i = Intent(this, T::class.java)
    i.putExtra(key, bundle)
    startActivity(i)
}