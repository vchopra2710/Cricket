package com.app.compose.cricket.utils

import android.text.Html
import android.text.Spanned


fun fromHtml(html: String): Spanned? {
    return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
}