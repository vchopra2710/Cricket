package com.app.compose.cricket.data.network.model.currentmatches

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TeamInfoDto(
    @SerialName("img") val img: String,
    @SerialName("name") val name: String,
    @SerialName("shortname") val shortname: String
)