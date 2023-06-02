package com.app.compose.cricket.data.network.model.cricscore

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CricketDataDto(
    @SerialName("dateTimeGMT") val dateTimeGMT: String,
    @SerialName("id") val id: String,
    @SerialName("matchType") val matchType: String,
    @SerialName("ms") val ms: String,
    @SerialName("status") val status: String,
    @SerialName("t1") val t1: String,
    @SerialName("t1img") val t1img: String? = null,
    @SerialName("t1s") val t1s: String,
    @SerialName("t2") val t2: String,
    @SerialName("t2img") val t2img: String? = null,
    @SerialName("t2s") val t2s: String
)