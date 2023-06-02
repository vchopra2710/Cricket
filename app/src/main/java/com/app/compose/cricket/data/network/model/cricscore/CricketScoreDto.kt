package com.app.compose.cricket.data.network.model.cricscore

import com.app.compose.cricket.data.network.model.InfoDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CricketScoreDto(
    @SerialName("apikey") val apikey: String,
    @SerialName("data") val cricketData: List<CricketDataDto>,
    @SerialName("info") val info: InfoDto,
    @SerialName("status") val status: String
)