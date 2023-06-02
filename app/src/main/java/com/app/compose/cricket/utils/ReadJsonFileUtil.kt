package com.app.compose.cricket.utils

import android.content.Context
import androidx.annotation.RawRes
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.StringWriter

fun Context.readJsonFile(@RawRes id: Int): String {
    val raw = this.resources.openRawResource(id)
    val writer = StringWriter()
    val buffer = CharArray(1024)
    raw.use { rawData ->
        val reader = BufferedReader(InputStreamReader(rawData, "UTF-8"))
        var n: Int
        while (reader.read(buffer).also { n = it } != -1) {
            writer.write(buffer, 0, n)
        }
    }
    return writer.toString()
}