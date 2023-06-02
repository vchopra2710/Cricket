package com.app.compose.cricket.usecase

import com.app.compose.cricket.domain.model.currentmatches.CurrentMatch
import com.app.compose.cricket.domain.repository.ICricketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCurrentMatchUseCase @Inject constructor(
    private val repository: ICricketRepository
) {
    suspend operator fun invoke(): CurrentMatch {
        val currentMatch = withContext(Dispatchers.IO) {
            repository.getCurrentMatches()
        }

        return currentMatch
    }
}