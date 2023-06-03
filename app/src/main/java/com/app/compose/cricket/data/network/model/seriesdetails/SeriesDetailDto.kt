package com.app.compose.cricket.data.network.model.seriesdetails

import com.app.compose.cricket.domain.model.seriesdetails.SeriesInfoDetail
import com.app.compose.cricket.domain.model.seriesdetails.SeriesMatch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeriesDetailDto(
    @SerialName("info") val info: SeriesInfoDetailDto,
    @SerialName("matchList") val matchList: List<SeriesMatchDto>
)