package com.app.compose.cricket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.app.compose.cricket.ui.compose.SystemUiController
import com.app.compose.cricket.ui.home.HomeScreen
import com.app.compose.cricket.ui.theme.CricketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            SystemUiController()
            CricketTheme { HomeScreen() }
        }
    }
}