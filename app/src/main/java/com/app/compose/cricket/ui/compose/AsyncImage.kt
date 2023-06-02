package com.app.compose.cricket.ui.compose

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun AsyncImage(
    url:String
)= coil.compose.AsyncImage(
    model = url,
    contentDescription = null,
    modifier = Modifier
        .size(32.dp)
        .clip(RoundedCornerShape(10.dp))
)