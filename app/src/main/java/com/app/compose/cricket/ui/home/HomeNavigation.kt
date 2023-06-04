package com.app.compose.cricket.ui.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.app.compose.cricket.ui.bottomnavigation.NavigationItem.*
import com.app.compose.cricket.ui.match.MatchScreen
import com.app.compose.cricket.ui.fantasy.FantasyScreen
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
    fantasyScreen()
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
private fun NavGraphBuilder.fantasyScreen() = composable(
    route = FANTASY.route,
    enterTransition = { enter() },
    exitTransition = { exit() },
    content = { FantasyScreen() })

@OptIn(ExperimentalAnimationApi::class)
private fun NavGraphBuilder.seriesScreen() = composable(
    route = SERIES.route,
    enterTransition = { enter() },
    exitTransition = { exit() },
    content = { SeriesScreen() }
)