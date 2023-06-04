package com.app.compose.cricket.di

import android.content.Context
import com.app.compose.cricket.data.repository.CricketNewsFeedRepository
import com.app.compose.cricket.data.repository.CricketRepository
import com.app.compose.cricket.domain.repository.ICricketNewsFeedRepository
import com.app.compose.cricket.domain.repository.ICricketRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideCricketApi(
        @ApplicationContext context: Context,
        client: HttpClient,
    ): ICricketRepository = CricketRepository(
        context = context,
        client = client,
    )

    @Singleton
    @Provides
    fun provideNewsApi(
        @ApplicationContext context: Context,
        client: HttpClient,
    ): ICricketNewsFeedRepository = CricketNewsFeedRepository(
        context = context,
        client = client,
    )
}