package com.app.compose.cricket.domain.repository

import com.app.compose.cricket.domain.model.currentmatches.CurrentMatch
import com.app.compose.cricket.domain.model.series.Series

interface ICricketRepository {
    suspend fun getCurrentMatches(): CurrentMatch
    suspend fun getSeries(): Series
}