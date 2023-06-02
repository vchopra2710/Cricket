package com.app.compose.cricket.ui.bottomnavigation

import androidx.annotation.StringRes
import com.app.compose.cricket.R

enum class NavigationItem(
    @StringRes val title: Int,
    val route: String,
) {
    MATCH(
        title = R.string.match_tab,
        route = "route_match",
    ),
    SCORE(
        title = R.string.score_tab,
        route = "route_score",
    ),
    SERIES(
        title = R.string.series_tab,
        route = "route_series",
    )
}