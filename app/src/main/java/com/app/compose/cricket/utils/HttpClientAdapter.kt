package com.app.compose.cricket.utils

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HttpClientAdapter {
    fun publicClient(): HttpClient = HttpClient(OkHttp) { installDefaultPlugins() }

    private fun HttpClientConfig<OkHttpConfig>.installDefaultPlugins() {
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    logDebug(message)
                }
            }
            level = LogLevel.ALL
        }

        install(UserAgent) { agent = "ktor" }

        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
    }
}