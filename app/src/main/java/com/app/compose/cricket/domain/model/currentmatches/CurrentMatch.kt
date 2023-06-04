package com.app.compose.cricket.domain.model.currentmatches

import com.app.compose.cricket.domain.model.Info
import kotlinx.serialization.Serializable

@Serializable
data class CurrentMatch(
    val data: List<Data>,
    val info: Info,
    val status: String
)