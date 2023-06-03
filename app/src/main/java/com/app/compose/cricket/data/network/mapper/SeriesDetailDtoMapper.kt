package com.app.compose.cricket.data.network.mapper

import com.app.compose.cricket.data.network.model.seriesdetails.SeriesDetailDto
import com.app.compose.cricket.data.network.model.seriesdetails.SeriesInfoDetailDto
import com.app.compose.cricket.data.network.model.seriesdetails.SeriesInfoDto
import com.app.compose.cricket.data.network.model.seriesdetails.SeriesMatchDto
import com.app.compose.cricket.data.network.model.seriesdetails.SeriesTeamInfoDto
import com.app.compose.cricket.domain.model.seriesdetails.SeriesDetail
import com.app.compose.cricket.domain.model.seriesdetails.SeriesInfo
import com.app.compose.cricket.domain.model.seriesdetails.SeriesInfoDetail
import com.app.compose.cricket.domain.model.seriesdetails.SeriesMatch
import com.app.compose.cricket.domain.model.seriesdetails.SeriesTeamInfo

fun SeriesInfoDto.toDomain(): SeriesInfo = SeriesInfo(
    data = data.toSeriesDetailDomain(),
    info = info.toInfoDomain(),
    status = status,
)

private fun SeriesDetailDto.toSeriesDetailDomain(): SeriesDetail = SeriesDetail(
    info = info.toSeriesInfoDetailDomain(),
    matchList = matchList.toSeriesMatchDomain(),
)

private fun SeriesInfoDetailDto.toSeriesInfoDetailDomain(): SeriesInfoDetail = SeriesInfoDetail(
    endDate = endDate,
    id = id,
    matches = matches,
    name = name,
    odi = odi,
    squads = squads,
    startDate = startDate,
    t20 = t20,
    test = test,
)

private fun List<SeriesMatchDto>.toSeriesMatchDomain() = this.map {
    SeriesMatch(
        bbbEnabled = it.bbbEnabled,
        date = it.date,
        dateTimeGMT = it.dateTimeGMT,
        fantasyEnabled = it.fantasyEnabled,
        hasSquad = it.hasSquad,
        id = it.id,
        matchEnded = it.matchEnded,
        matchStarted = it.matchStarted,
        matchType = it.matchType,
        name = it.name,
        status = it.status,
        teamInfo = it.teamInfo.toSeriesTeamInfoDomain(),
        teams = it.teams,
        venue = it.venue,
    )
}

private fun List<SeriesTeamInfoDto>.toSeriesTeamInfoDomain() = this.map {
    SeriesTeamInfo(
        img = it.img,
        name = it.name,
        shortname = it.shortname,
    )
}