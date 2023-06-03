package com.app.compose.cricket.data.repository

import android.content.Context
import com.app.compose.cricket.BuildConfig
import com.app.compose.cricket.R
import com.app.compose.cricket.data.network.ApiUrls
import com.app.compose.cricket.data.network.mapper.toDomain
import com.app.compose.cricket.data.network.model.cricscore.CricketScoreDto
import com.app.compose.cricket.data.network.model.currentmatches.CurrentMatchDto
import com.app.compose.cricket.data.network.model.series.SeriesDto
import com.app.compose.cricket.data.network.model.seriesdetails.SeriesInfoDto
import com.app.compose.cricket.domain.model.cricscore.CricketScore
import com.app.compose.cricket.domain.model.currentmatches.CurrentMatch
import com.app.compose.cricket.domain.model.series.Series
import com.app.compose.cricket.domain.model.seriesdetails.SeriesInfo
import com.app.compose.cricket.domain.repository.ICricketRepository
import com.app.compose.cricket.utils.readJsonFile
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import kotlinx.serialization.json.Json
import javax.inject.Inject

private const val CONNECT_WITH_API = false

class CricketRepository @Inject constructor(
    private val context: Context,
    private val client: HttpClient
) : ICricketRepository {

    private val json = Json {
        explicitNulls = false
    }

    override suspend fun getCurrentMatches(): CurrentMatch = if (CONNECT_WITH_API) {
        client.request(ApiUrls.CURRENT_CRICKET_MATCHES.url) {
            method = HttpMethod.Get
            url {
                parameters.append("apikey", BuildConfig.API_KEY)
                parameters.append("offset", "0")
            }
        }.body<CurrentMatchDto>()
    } else {
        val currentMatchesString = context.readJsonFile(id = R.raw.current_match_dto)
        json.decodeFromString<CurrentMatchDto>(currentMatchesString)
    }.toDomain()

    override suspend fun getSeries(): Series = if (CONNECT_WITH_API) {
        client.request(ApiUrls.SERIES.url) {
            method = HttpMethod.Get
            url {
                parameters.append("apikey", BuildConfig.API_KEY)
                parameters.append("offset", "0")
            }
        }.body<SeriesDto>()
    } else {
        val seriesString = context.readJsonFile(id = R.raw.series_list)
        json.decodeFromString<SeriesDto>(seriesString)
    }.toDomain()

    override suspend fun getCricketScore(): CricketScore = if (CONNECT_WITH_API) {
        client.request(ApiUrls.CRICKET_SCORE.url) {
            method = HttpMethod.Get
            url {
                parameters.append("apikey", BuildConfig.API_KEY)
                parameters.append("offset", "0")
            }
        }.body<CricketScoreDto>()
    } else {
        val cricketScoreString = context.readJsonFile(id = R.raw.cric_score)
        json.decodeFromString<CricketScoreDto>(cricketScoreString)
    }.toDomain()

    override suspend fun getSeriesDetails(
        seriesId: String,
    ): SeriesInfo = if (CONNECT_WITH_API) {
        client.request(ApiUrls.SERIES_DETAILS.url) {
            method = HttpMethod.Get
            url {
                parameters.append("apikey", BuildConfig.API_KEY)
                parameters.append("id", seriesId)
            }
        }.body<SeriesInfoDto>()
    } else {
        val seriesInfoString = context.readJsonFile(id = R.raw.series_info)
        json.decodeFromString<SeriesInfoDto>(seriesInfoString)
    }.toDomain()
}