package com.app.compose.cricket.domain.model.currentmatches

import kotlinx.serialization.Serializable

@Serializable
data class TeamInfo(
    val img: String,
    val name: String,
    val shortname: String,
)