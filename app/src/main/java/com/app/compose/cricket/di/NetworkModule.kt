package com.app.compose.cricket.di

import com.app.compose.cricket.domain.repository.ICricketRepository
import com.app.compose.cricket.data.repository.CricketRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideCricketApi(
        client: HttpClient,
    ): ICricketRepository = CricketRepository(client = client)
}