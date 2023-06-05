package com.app.compose.cricket.domain.repository

import com.app.compose.cricket.domain.model.newsfeed.CricketNewsFeed

interface ICricketNewsFeedRepository {
    suspend fun getCricketNewsFeed(query: String): CricketNewsFeed
}