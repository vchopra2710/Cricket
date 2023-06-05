package com.app.compose.cricket.ui.newsfeed

import com.app.compose.cricket.domain.model.Countries
import com.app.compose.cricket.domain.model.newsfeed.Article

data class NewsFeedState(
    val articles: List<Article> = listOf(),
    val article: Article? = null,
    val countryList: List<Countries> = Countries.values().toList(),
) {
    val zoomedCountry: Countries = countryList.first { it.zoomIn }
}
