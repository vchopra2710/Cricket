package com.app.compose.cricket.utils

import android.content.Context
import android.graphics.Bitmap
import androidx.core.graphics.drawable.toBitmap
import coil.imageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

suspend fun Context.getBitmapFromUrl(
    url: String
): Bitmap = withContext(Dispatchers.IO) {
    val request = ImageRequest.Builder(this@getBitmapFromUrl)
        .data(url)
        .build()
    val result = (imageLoader.execute(request))
    val drawable = (result as SuccessResult).drawable
    drawable.toBitmap()
}