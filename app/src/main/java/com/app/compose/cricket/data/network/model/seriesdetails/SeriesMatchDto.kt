package com.app.compose.cricket.data.network.model.seriesdetails

import com.app.compose.cricket.domain.model.seriesdetails.SeriesTeamInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeriesMatchDto(
    @SerialName("bbbEnabled") val bbbEnabled: Boolean,
    @SerialName("date") val date: String,
    @SerialName("dateTimeGMT") val dateTimeGMT: String,
    @SerialName("fantasyEnabled") val fantasyEnabled: Boolean,
    @SerialName("hasSquad") val hasSquad: Boolean,
    @SerialName("id") val id: String,
    @SerialName("matchEnded") val matchEnded: Boolean,
    @SerialName("matchStarted") val matchStarted: Boolean,
    @SerialName("matchType") val matchType: String,
    @SerialName("name") val name: String,
    @SerialName("status") val status: String,
    @SerialName("teamInfo") val teamInfo: List<SeriesTeamInfoDto>,
    @SerialName("teams") val teams: List<String>,
    @SerialName("venue") val venue: String,
)