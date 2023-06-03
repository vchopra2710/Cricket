package com.app.compose.cricket.domain.model.seriesdetails

data class SeriesInfoDetail(
    val endDate: String,
    val id: String,
    val matches: Int,
    val name: String,
    val odi: Int,
    val squads: Int,
    val startDate: String,
    val t20: Int,
    val test: Int
)