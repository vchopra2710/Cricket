package com.app.compose.cricket.domain.model.seriesdetails

data class SeriesMatch(
    val bbbEnabled: Boolean,
    val date: String,
    val dateTimeGMT: String,
    val fantasyEnabled: Boolean,
    val hasSquad: Boolean,
    val id: String,
    val matchEnded: Boolean,
    val matchStarted: Boolean,
    val matchType: String,
    val name: String,
    val status: String,
    val teamInfo: List<SeriesTeamInfo>,
    val teams: List<String>,
    val venue: String,
)