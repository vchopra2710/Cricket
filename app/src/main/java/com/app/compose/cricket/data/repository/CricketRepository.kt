package com.app.compose.cricket.data.repository

import com.app.compose.cricket.BuildConfig
import com.app.compose.cricket.data.network.ApiUrls
import com.app.compose.cricket.domain.repository.ICricketRepository
import com.app.compose.cricket.data.network.model.currentmatches.CurrentMatchDto
import com.app.compose.cricket.utils.logDebug
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import javax.inject.Inject

class CricketRepository @Inject constructor(
    private val client: HttpClient
) : ICricketRepository {

    override suspend fun getCurrentMatches() {
        val response: HttpResponse = client.request(ApiUrls.CURRENT_CRICKET_MATCHES.url) {
            method = HttpMethod.Get
            url {
                parameters.append("apikey", BuildConfig.API_KEY)
                parameters.append("offset", "0")
            }
        }

        val currentMatchDto = response.body<CurrentMatchDto>()
        logDebug("currentMatchDto: $currentMatchDto")
    }
}