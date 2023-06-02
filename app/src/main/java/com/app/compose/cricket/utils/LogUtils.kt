package com.app.compose.cricket.utils

import android.util.Log

const val TAG = "_dbg"

inline fun <reified T> T.logDebug(message: String) {
    Log.d("$TAG ${T::class.java.simpleName}", message)
}

inline fun <reified T> T.logError(message: String, exp: Exception? = null) {
    Log.e("$TAG ${T::class.java.simpleName}", message, exp)
}

inline fun <reified T> T.logInfo(message: String) {
    Log.i("$TAG ${T::class.java.simpleName}", message)
}

inline fun <reified T> T.logWarning(message: String) {
    Log.w("$TAG ${T::class.java.simpleName}", message)
}