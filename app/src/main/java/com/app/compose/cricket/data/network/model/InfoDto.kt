package com.app.compose.cricket.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfoDto(
    @SerialName("hitsToday") val hitsToday: Int,
    @SerialName("hitsUsed") val hitsUsed: Int,
    @SerialName("hitsLimit") val hitsLimit: Int,
    @SerialName("credits") val credits: Int,
    @SerialName("server") val server: Int,
    @SerialName("offsetRows") val offsetRows: Int? = null,
    @SerialName("totalRows") val totalRows: Int? = null,
    @SerialName("queryTime") val queryTime: Double,
    @SerialName("s") val s: Int,
    @SerialName("cache") val cache: Int? = null,
)