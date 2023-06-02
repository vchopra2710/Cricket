package com.app.compose.cricket.data.network.mapper

import com.app.compose.cricket.data.network.model.cricscore.CricketDataDto
import com.app.compose.cricket.data.network.model.cricscore.CricketScoreDto
import com.app.compose.cricket.domain.model.cricscore.CricketData
import com.app.compose.cricket.domain.model.cricscore.CricketScore

fun CricketScoreDto.toDomain(): CricketScore = CricketScore(
    cricketData = cricketData.toCricketDomain(),
    info = info.toInfoDomain(),
    status = status,
)

private fun List<CricketDataDto>.toCricketDomain() = this.map {
    CricketData(
        dateTimeGMT = it.dateTimeGMT,
        id = it.id,
        matchType = it.matchType,
        ms = it.ms,
        status = it.status,
        team1 = it.t1,
        team1Img = it.t1img,
        team1Score = it.t1s,
        team2 = it.t2,
        team2Img = it.t2img,
        team2Score = it.t2s,
    )
}