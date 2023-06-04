package com.app.compose.cricket.data.repository

import android.content.Context
import com.app.compose.cricket.BuildConfig
import com.app.compose.cricket.R
import com.app.compose.cricket.data.network.ApiRoutes
import com.app.compose.cricket.data.network.ApiRoutes.CONNECT_TO_NEWS_BE
import com.app.compose.cricket.data.network.mapper.toDomain
import com.app.compose.cricket.data.network.model.newsfeed.CricketNewsFeedDto
import com.app.compose.cricket.domain.model.newsfeed.CricketNewsFeed
import com.app.compose.cricket.domain.repository.ICricketNewsFeedRepository
import com.app.compose.cricket.utils.readJsonFile
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import kotlinx.serialization.json.Json
import javax.inject.Inject

private const val NEWS_API_KEY = BuildConfig.NEWS_API_KEY

class CricketNewsFeedRepository @Inject constructor(
    private val context: Context,
    private val client: HttpClient
) : ICricketNewsFeedRepository {

    private val json = Json {
        explicitNulls = false
    }

    override suspend fun getCricketNewsFeed(): CricketNewsFeed = if (CONNECT_TO_NEWS_BE) {
        client.request(ApiRoutes.GET_EVERY_NEWS) {
            method = HttpMethod.Get

            url {
                parameters.append("apiKey", NEWS_API_KEY)
                parameters.append("q", "cricket+t20+odi+test+india")
            }
        }.body<CricketNewsFeedDto>()
    } else {
        val currentMatchesString = context.readJsonFile(id = R.raw.cricket_news_feed)
        json.decodeFromString<CricketNewsFeedDto>(currentMatchesString)
    }.toDomain()
}