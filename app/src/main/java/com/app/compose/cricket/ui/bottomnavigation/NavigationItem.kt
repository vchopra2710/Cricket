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
    FANTASY(
        title = R.string.fantasy_tab,
        icon = R.drawable.ic_shopping_basket,
        route = "route_fantasy",
    ),
    SERIES(
        title = R.string.series_tab,
        icon = R.drawable.ic_cricket,
        route = "route_series",
    )
}