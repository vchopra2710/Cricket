package com.app.compose.cricket.domain.repository

import com.app.compose.cricket.domain.model.currentmatches.CurrentMatch

interface ICricketRepository {
    suspend fun getCurrentMatches(): CurrentMatch
}