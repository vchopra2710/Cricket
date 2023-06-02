package com.app.compose.cricket.domain.repository

interface ICricketRepository {
    suspend fun getCurrentMatches()
}