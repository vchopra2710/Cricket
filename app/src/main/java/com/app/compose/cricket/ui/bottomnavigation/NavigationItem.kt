package com.app.compose.cricket.ui.bottomnavigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.app.compose.cricket.R

enum class NavigationItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String,
) {
    MATCH(
        title = R.string.match_tab,
        icon = R.drawable.list,
        route = "route_match",
    ),
    SCORE(
        title = R.string.score_tab,
        icon = R.drawable.view_list,
        route = "route_score",
    ),
    SERIES(
        title = R.string.series_tab,
        icon = R.drawable.cricket,
        route = "route_series",
    )
}