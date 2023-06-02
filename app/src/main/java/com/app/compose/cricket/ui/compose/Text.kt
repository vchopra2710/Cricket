package com.app.compose.cricket.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun Text(
    text: String,
    fontSize: TextUnit = 12.sp,
    maxLines: Int = 1,
    color: Color = Color.White,
    fontWeight: FontWeight = FontWeight.Normal,
) = androidx.compose.material.Text(
    text = text,
    maxLines = maxLines,
    fontSize = fontSize,
    color = color,
    fontWeight = fontWeight,
)