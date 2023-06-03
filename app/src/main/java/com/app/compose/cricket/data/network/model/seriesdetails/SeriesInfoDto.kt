package com.app.compose.cricket.data.network.model.seriesdetails

import com.app.compose.cricket.data.network.model.InfoDto
import com.app.compose.cricket.domain.model.seriesdetails.SeriesDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeriesInfoDto(
    @SerialName("apikey") val apikey: String,
    @SerialName("data") val data: SeriesDetailDto,
    @SerialName("info") val info: InfoDto,
    @SerialName("status") val status: String
)