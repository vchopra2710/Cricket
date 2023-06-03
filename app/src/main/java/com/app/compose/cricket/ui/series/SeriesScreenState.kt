package com.app.compose.cricket.ui.series

import com.app.compose.cricket.domain.model.series.Series
import com.app.compose.cricket.domain.model.seriesdetails.SeriesInfo

data class SeriesScreenState(
    val series: Series? = null,
    val seriesInfo: SeriesInfo? = null,
)
