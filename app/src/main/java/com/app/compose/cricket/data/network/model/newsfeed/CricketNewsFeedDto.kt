package com.app.compose.cricket.data.network.model.newsfeed

import com.app.compose.cricket.domain.model.newsfeed.Article
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CricketNewsFeedDto(
    @SerialName("articles") val articles: List<ArticleDto>?,
    @SerialName("status") val status: String?,
    @SerialName("totalResults") val totalResults: Int?,
)