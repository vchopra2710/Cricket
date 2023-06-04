package com.app.compose.cricket.ui.home

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Left
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Right
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry
import com.app.compose.cricket.ui.bottomnavigation.NavigationItem.*

private const val ANIMATION_DURATION = 700

@OptIn(ExperimentalAnimationApi::class)
fun AnimatedContentScope<NavBackStackEntry>.enter(): EnterTransition? {
    val (from, to) = destination()
    return when (from) {
        MATCH.route -> slideIntoContainer(Left, animationSpec = tween(ANIMATION_DURATION))
        FANTASY.route -> when (to) {
            MATCH.route -> slideIntoContainer(Right, animationSpec = tween(ANIMATION_DURATION))
            SERIES.route -> slideIntoContainer(Left, animationSpec = tween(ANIMATION_DURATION))
            else -> null
        }
        SERIES.route -> slideIntoContainer(Right, animationSpec = tween(ANIMATION_DURATION))
        else -> null
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun AnimatedContentScope<NavBackStackEntry>.exit(): ExitTransition? {
    val (from, to) = destination()
    return when (to) {
        MATCH.route -> slideOutOfContainer(Right, animationSpec = tween(ANIMATION_DURATION))
        FANTASY.route -> when (from) {
            MATCH.route -> slideOutOfContainer(Left, animationSpec = tween(ANIMATION_DURATION))
            SERIES.route -> slideOutOfContainer(Right, animationSpec = tween(ANIMATION_DURATION))
            else -> null
        }
        SERIES.route -> slideOutOfContainer(Left, animationSpec = tween(ANIMATION_DURATION))
        else -> null
    }
}

@OptIn(ExperimentalAnimationApi::class)
private fun AnimatedContentScope<NavBackStackEntry>.destination(): Pair<String?, String?> {
    return Pair(initialState.destination.route, targetState.destination.route)
}