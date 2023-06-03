package com.app.compose.cricket.ui.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.app.compose.cricket.ui.bottomnavigation.NavigationBar
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun HomeScreen(
    navController: NavHostController = rememberAnimatedNavController(),
) = Scaffold(
    bottomBar = { NavigationBar(navController = navController) },
    modifier = Modifier.navigationBarsPadding(),
    backgroundColor = MaterialTheme.colors.background
) { paddingValues ->
    Box(modifier = Modifier.padding(paddingValues)) {
        HomeNavigation(navController = navController)
    }
}