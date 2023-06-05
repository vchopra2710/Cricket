package com.app.compose.cricket.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import java.net.URL

fun Context.bitmapDescriptor(
    @DrawableRes id: Int
): BitmapDescriptor? {
    val drawable = ContextCompat.getDrawable(this, id) ?: return null
    drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
    val bm = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )
    val canvas = android.graphics.Canvas(bm)
    drawable.draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bm)
}

fun getBitmapFromStream(url: String): Bitmap? = try {
    BitmapFactory.decodeStream(
        URL(url).openConnection().getInputStream()
    )
} catch (e: Exception) {
    null
}