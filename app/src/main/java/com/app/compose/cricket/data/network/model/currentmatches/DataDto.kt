package com.app.compose.cricket.data.network.model.currentmatches

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataDto(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("matchType") val matchType: String,
    @SerialName("status") val status: String,
    @SerialName("venue") val venue: String,
    @SerialName("date") val date: String,
    @SerialName("dateTimeGMT") val dateTimeGMT: String,
    @SerialName("teams") val teams: List<String>,
    @SerialName("teamInfo") val teamInfo: List<TeamInfoDto>,
    @SerialName("score") val score: List<ScoreDto>,
    @SerialName("series_id") val seriesId: String,
    @SerialName("fantasyEnabled") val fantasyEnabled: Boolean,
    @SerialName("bbbEnabled") val bbbEnabled: Boolean,
    @SerialName("hasSquad") val hasSquad: Boolean,
    @SerialName("matchEnded") val matchEnded: Boolean,
    @SerialName("matchStarted") val matchStarted: Boolean
)