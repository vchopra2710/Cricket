package com.app.compose.cricket.domain.model.seriesdetails

import com.app.compose.cricket.domain.model.Info

data class SeriesInfo(
    val data: SeriesDetail,
    val info: Info,
    val status: String
)