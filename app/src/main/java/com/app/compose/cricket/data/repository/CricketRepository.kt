package com.app.compose.cricket.data.repository

import android.content.Context
import com.app.compose.cricket.BuildConfig
import com.app.compose.cricket.R
import com.app.compose.cricket.data.network.ApiUrls
import com.app.compose.cricket.data.network.mapper.toDomain
import com.app.compose.cricket.data.network.model.currentmatches.CurrentMatchDto
import com.app.compose.cricket.domain.model.currentmatches.CurrentMatch
import com.app.compose.cricket.domain.repository.ICricketRepository
import com.app.compose.cricket.utils.readJsonFile
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import kotlinx.serialization.json.Json
import javax.inject.Inject

private const val CONNECT_WITH_API = false

class CricketRepository @Inject constructor(
    private val context: Context,
    private val client: HttpClient
) : ICricketRepository {

    override suspend fun getCurrentMatches(): CurrentMatch {
        val currentMatchDto: CurrentMatchDto =
            if (CONNECT_WITH_API) {
                val response: HttpResponse = client.request(ApiUrls.CURRENT_CRICKET_MATCHES.url) {
                    method = HttpMethod.Get
                    url {
                        parameters.append("apikey", BuildConfig.API_KEY)
                        parameters.append("offset", "0")
                    }
                }

                response.body()
            } else {
                val currentMatchesString = context.readJsonFile(id = R.raw.cuurent_match_dto)
                Json.decodeFromString(currentMatchesString)
            }

        return currentMatchDto.toDomain()
    }
}