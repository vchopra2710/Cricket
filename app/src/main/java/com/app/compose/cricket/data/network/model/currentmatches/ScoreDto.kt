package com.app.compose.cricket.data.network.model.currentmatches

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScoreDto(
    @SerialName("inning") val inning: String,
    @SerialName("o") val over: Double,
    @SerialName("r") val run: Int,
    @SerialName("w") val wicket: Int
)