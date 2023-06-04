package com.app.compose.cricket.data.network.mapper

import com.app.compose.cricket.data.network.model.newsfeed.ArticleDto
import com.app.compose.cricket.data.network.model.newsfeed.CricketNewsFeedDto
import com.app.compose.cricket.data.network.model.newsfeed.SourceDto
import com.app.compose.cricket.domain.model.newsfeed.Article
import com.app.compose.cricket.domain.model.newsfeed.CricketNewsFeed
import com.app.compose.cricket.domain.model.newsfeed.Source

fun CricketNewsFeedDto.toDomain() = CricketNewsFeed(
    articles = articles.toArticleDomain(),
    status = status,
    totalResults = totalResults,
)

private fun List<ArticleDto>?.toArticleDomain() = this?.map {
    Article(
        author = it.author,
        content = it.content,
        description = it.description,
        publishedAt = it.publishedAt,
        source = it.source.toSourceDomain(),
        title = it.title,
        url = it.url,
        urlToImage = it.urlToImage,
    )
}

private fun SourceDto?.toSourceDomain(): Source? = this?.let {
    Source(
        id = id,
        name = name,
    )
}