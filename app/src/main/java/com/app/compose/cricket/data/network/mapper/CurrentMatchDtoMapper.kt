package com.app.compose.cricket.data.network.mapper

import com.app.compose.cricket.data.network.model.currentmatches.CurrentMatchDto
import com.app.compose.cricket.data.network.model.currentmatches.DataDto
import com.app.compose.cricket.data.network.model.currentmatches.InfoDto
import com.app.compose.cricket.data.network.model.currentmatches.ScoreDto
import com.app.compose.cricket.data.network.model.currentmatches.TeamInfoDto
import com.app.compose.cricket.domain.model.currentmatches.CurrentMatch
import com.app.compose.cricket.domain.model.currentmatches.Data
import com.app.compose.cricket.domain.model.currentmatches.Info
import com.app.compose.cricket.domain.model.currentmatches.Score
import com.app.compose.cricket.domain.model.currentmatches.TeamInfo

fun CurrentMatchDto.toDomain(): CurrentMatch = CurrentMatch(
    data = data.toDataDomain(),
    info = info.toInfoDomain(),
    status = status,
)

private fun List<DataDto>.toDataDomain(): List<Data> = this.map {
    Data(
        id = it.id,
        name = it.name,
        matchType = it.matchType,
        status = it.status,
        venue = it.venue,
        date = it.date,
        dateTimeGMT = it.dateTimeGMT,
        teams = it.teams,
        teamInfo = it.teamInfo.toTeamInfoDomain(),
        score = it.score.toScoreDomain(),
        seriesId = it.seriesId,
        fantasyEnabled = it.fantasyEnabled,
        bbbEnabled = it.bbbEnabled,
        hasSquad = it.hasSquad,
        matchEnded = it.matchEnded,
        matchStarted = it.matchStarted,
    )
}

private fun InfoDto.toInfoDomain(): Info = Info(
    hitsToday = hitsToday,
    hitsUsed = hitsUsed,
    hitsLimit = hitsLimit,
    credits = credits,
    server = server,
    offsetRows = offsetRows,
    totalRows = totalRows,
    queryTime = queryTime,
    s = s,
    cache = cache,
)

private fun List<TeamInfoDto>.toTeamInfoDomain(): List<TeamInfo> = this.map {
    TeamInfo(
        img = it.img,
        name = it.name,
        shortname = it.shortname,
    )
}

private fun List<ScoreDto>.toScoreDomain(): List<Score> = this.map {
    Score(
        inning = it.inning,
        over = it.over,
        run = it.run,
        wicket = it.wicket,
    )
}