package com.app.compose.cricket.data.network.model.series

import com.app.compose.cricket.data.network.model.InfoDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeriesDto(
    @SerialName("apikey") val apikey: String,
    @SerialName("data") val seriesData: List<SeriesDataDto>,
    @SerialName("info") val seriesInfo: InfoDto,
    @SerialName("status") val status: String
)