package com.app.compose.cricket.data.network

object ApiRoutes {
    private const val CRICKET_BASE_URL = "https://api.cricapi.com/v1"
    const val CURRENT_CRICKET_MATCHES = "$CRICKET_BASE_URL/currentMatches"
    const val SERIES = "$CRICKET_BASE_URL/series"
    const val CRICKET_SCORE = "$CRICKET_BASE_URL/cricScore"
    const val SERIES_DETAILS = "$CRICKET_BASE_URL/series_info"

    private const val NEWS_BASE_URL = "https://newsapi.org/v2"
    const val GET_EVERY_NEWS = "$NEWS_BASE_URL/everything"

    const val CONNECT_TO_CRICKET_BE = false
    const val CONNECT_TO_NEWS_BE = false
}