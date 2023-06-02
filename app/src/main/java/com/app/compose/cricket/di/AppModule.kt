package com.app.compose.cricket.di

import com.app.compose.cricket.utils.HttpClientAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesPublicHttpClient(): HttpClient = HttpClientAdapter.publicClient()
}