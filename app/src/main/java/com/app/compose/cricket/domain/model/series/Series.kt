package com.app.compose.cricket.domain.model.series

import com.app.compose.cricket.domain.model.Info

data class Series(
    val seriesData: List<SeriesData>,
    val seriesInfo: Info,
    val status: String
)