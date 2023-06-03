package com.app.compose.cricket.domain.repository

import com.app.compose.cricket.domain.model.cricscore.CricketScore
import com.app.compose.cricket.domain.model.currentmatches.CurrentMatch
import com.app.compose.cricket.domain.model.series.Series
import com.app.compose.cricket.domain.model.seriesdetails.SeriesDetail
import com.app.compose.cricket.domain.model.seriesdetails.SeriesInfo

interface ICricketRepository {
    suspend fun getCurrentMatches(): CurrentMatch
    suspend fun getSeries(): Series
    suspend fun getCricketScore(): CricketScore
    suspend fun getSeriesDetails(seriesId: String): SeriesInfo
}