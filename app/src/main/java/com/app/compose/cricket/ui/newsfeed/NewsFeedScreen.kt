package com.app.compose.cricket.ui.newsfeed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.app.compose.cricket.ui.compose.Text

@Composable
fun NewsFeedScreen() = Column(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .statusBarsPadding(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
) {
    Text(text = "news feed screen")
}