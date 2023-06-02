package com.app.compose.cricket.domain.model.currentmatches

data class Data(
    val id: String,
    val name: String,
    val matchType: String,
    val status: String,
    val venue: String,
    val date: String,
    val dateTimeGMT: String,
    val teams: List<String>,
    val teamInfo: List<TeamInfoDto>,
    val score: List<Score>,
    val seriesId: String,
    val fantasyEnabled: Boolean,
    val bbbEnabled: Boolean,
    val hasSquad: Boolean,
    val matchEnded: Boolean,
    val matchStarted: Boolean
)