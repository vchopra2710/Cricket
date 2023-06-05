package com.app.compose.cricket.domain.model

import androidx.annotation.DrawableRes
import com.app.compose.cricket.R
import com.google.android.gms.maps.model.LatLng

enum class Countries(
    val latLng: LatLng,
    val searchQuery: String,
    @DrawableRes val icon: Int,
    val zoomIn: Boolean = false,
) {
    INDIA(
        latLng = LatLng(23.020865274862206, 79.71427793374811),
        searchQuery = "india",
        icon = R.drawable.ic_india,
        zoomIn = true,
    ),
    AUSTRALIA(
        latLng = LatLng(-24.973477681127253, 133.25603863227082),
        searchQuery = "australia",
        icon = R.drawable.ic_australia,
    ),
    ENGLAND(
        latLng = LatLng(55.308664189329264, -3.0597779373774934),
        searchQuery = "england",
        icon = R.drawable.ic_england,
    ),
    SOUTH_AFRICA(
        latLng = LatLng(-30.947313681296027, 24.74157741414652),
        searchQuery = "south+africa",
        icon = R.drawable.ic_south_africa,
    ),
    NEW_ZEALAND(
        latLng = LatLng(-42.564558239634636, 173.01693235102704),
        searchQuery = "zealand",
        icon = R.drawable.ic_new_zealand,
    ),
    AFGHANISTAN(
        latLng = LatLng(33.985533972677786, 64.69538295400106),
        searchQuery = "afghanistan",
        icon = R.drawable.ic_afghanistan,
    ),
    BANGLADESH(
        latLng = LatLng(24.24796704194091, 90.31860227518014),
        searchQuery = "bangladesh",
        icon = R.drawable.ic_bangladesh,
    ),
    IRELAND(
        latLng = LatLng(53.18347905836287, -8.133626758752532),
        searchQuery = "ireland",
        icon = R.drawable.ic_ireland,
    ),
    SRI_LANKA(
        latLng = LatLng(7.616130328353532, 80.84259744553253),
        searchQuery = "lanka",
        icon = R.drawable.ic_sri_lanka,
    ),
    WEST_INDIES(
        latLng = LatLng(18.170412798947197, -77.36697467982613),
        searchQuery = "indies",
        icon = R.drawable.ic_west_indies,
    ),
    ZIMBABWE(
        latLng = LatLng(-19.038412901172936, 29.7422095708667),
        searchQuery = "zimbabwe",
        icon = R.drawable.ic_zimbabwe,
    ),
}
