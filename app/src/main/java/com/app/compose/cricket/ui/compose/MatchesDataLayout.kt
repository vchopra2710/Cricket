package com.app.compose.cricket.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MatchesDataLayout(matches: List<Pair<String, Int>>) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp),
    horizontalArrangement = Arrangement.SpaceBetween
) {
    matches.forEach {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = it.first,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = it.second.toString(),
                fontWeight = FontWeight.Bold,
            )
        }
        if (matches.lastIndexOf(it) != matches.size - 1) {
            Divider(
                modifier = Modifier
                    .height(40.dp)
                    .width(1.dp),
                color = Color.White
            )
        }
    }

}