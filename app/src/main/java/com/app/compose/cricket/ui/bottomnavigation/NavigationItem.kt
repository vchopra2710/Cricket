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
        icon = R.drawable.ic_list,
        route = "route_match",
    ),
    NEWS(
        title = R.string.news_feed_tab,
        icon = R.drawable.ic_feed,
        route = "route_news_feed",
    ),
    SERIES(
        title = R.string.series_tab,
        icon = R.drawable.ic_cricket,
        route = "route_series",
    )
}