package com.app.compose.cricket.data.network.model.currentmatches

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentMatchDto(
    @SerialName("apikey") val apikey: String,
    @SerialName("data") val data: List<DataDto>,
    @SerialName("info") val info: InfoDto,
    @SerialName("status") val status: String
)