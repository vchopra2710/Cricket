package com.app.compose.cricket.ui.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScoreRowView(
    image: String?,
    name: String,
    score: String,
) = Row(
    verticalAlignment = Alignment.CenterVertically,
) {
    image?.let { AsyncImage(url = it) }
        ?: Spacer(modifier = Modifier.size(32.dp))

    Spacer(modifier = Modifier.width(8.dp))
    Text(
        text = name,
        fontWeight = FontWeight.SemiBold,
    )
    Spacer(modifier = Modifier.weight(1f))
    Text(
        text = score,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
    )
}