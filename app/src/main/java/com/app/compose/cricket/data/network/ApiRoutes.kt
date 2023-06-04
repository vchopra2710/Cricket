package com.app.compose.cricket.data.network

object ApiRoutes {
    private const val BASE_URL = "https://api.cricapi.com/v1"
    const val CURRENT_CRICKET_MATCHES = "$BASE_URL/currentMatches"
    const val SERIES = "$BASE_URL/series"
    const val CRICKET_SCORE = "$BASE_URL/cricScore"
    const val SERIES_DETAILS = "$BASE_URL/series_info"
}