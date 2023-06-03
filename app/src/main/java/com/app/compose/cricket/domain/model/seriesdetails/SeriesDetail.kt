package com.app.compose.cricket.domain.model.seriesdetails


data class SeriesDetail(
    val info: SeriesInfoDetail,
    val matchList: List<SeriesMatch>
)