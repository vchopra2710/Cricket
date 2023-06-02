package com.app.compose.cricket.data.network.model.series

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeriesDataDto(
    @SerialName("endDate") val endDate: String,
    @SerialName("id") val id: String,
    @SerialName("matches") val matches: Int,
    @SerialName("name") val name: String,
    @SerialName("odi") val odi: Int,
    @SerialName("squads") val squads: Int,
    @SerialName("startDate") val startDate: String,
    @SerialName("t20") val t20: Int,
    @SerialName("test") val test: Int
)