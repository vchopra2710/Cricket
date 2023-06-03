package com.app.compose.cricket.ui.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.app.compose.cricket.ui.bottomnavigation.NavigationItem.*
import com.app.compose.cricket.ui.match.MatchScreen
import com.app.compose.cricket.ui.score.ScoreScreen
import com.app.compose.cricket.ui.series.SeriesScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeNavigation(navController: NavHostController) = AnimatedNavHost(
    navController = navController,
    startDestination = MATCH.route
) {
    matchScreen()
    scoreScreen()
    seriesScreen()
}

@OptIn(ExperimentalAnimationApi::class)
private fun NavGraphBuilder.matchScreen() = composable(
    route = MATCH.route,
    enterTransition = { enter() },
    exitTransition = { exit() },
    content = { MatchScreen() }
)

@OptIn(ExperimentalAnimationApi::class)
private fun NavGraphBuilder.scoreScreen() = composable(
    route = SCORE.route,
    enterTransition = { enter() },
    exitTransition = { exit() },
    content = { ScoreScreen() })

@OptIn(ExperimentalAnimationApi::class)
private fun NavGraphBuilder.seriesScreen() = composable(
    route = SERIES.route,
    enterTransition = { enter() },
    exitTransition = { exit() },
    content = { SeriesScreen() }
)