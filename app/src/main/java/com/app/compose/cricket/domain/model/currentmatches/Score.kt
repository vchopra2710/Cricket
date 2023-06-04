package com.app.compose.cricket.domain.model.currentmatches

import kotlinx.serialization.Serializable

@Serializable
data class Score(
    val inning: String,
    val over: Double,
    val run: Int,
    val wicket: Int
)