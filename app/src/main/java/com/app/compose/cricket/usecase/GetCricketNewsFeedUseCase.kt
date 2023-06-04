package com.app.compose.cricket.usecase

import com.app.compose.cricket.domain.model.newsfeed.CricketNewsFeed
import com.app.compose.cricket.domain.repository.ICricketNewsFeedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCricketNewsFeedUseCase @Inject constructor(
    private val repository: ICricketNewsFeedRepository,
) {
    suspend operator fun invoke(): CricketNewsFeed = withContext(Dispatchers.IO) {
        repository.getCricketNewsFeed()
    }
}