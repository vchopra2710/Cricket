package com.app.compose.cricket.data.network

enum class ApiUrls(val url: String) {
    CURRENT_CRICKET_MATCHES(url = "https://api.cricapi.com/v1/currentMatches"),
    SERIES(url = "https://api.cricapi.com/v1/series")
}