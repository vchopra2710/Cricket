package com.app.compose.cricket.domain.model.currentmatches

data class Score(
    val inning: String,
    val over: Double,
    val run: Int,
    val wicket: Int
)