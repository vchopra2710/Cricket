package com.app.compose.cricket.domain.model.newsfeed

data class CricketNewsFeed(
    val articles: List<Article>?,
    val status: String?,
    val totalResults: Int?,
)