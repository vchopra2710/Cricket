package com.app.compose.cricket.usecase

import com.app.compose.cricket.domain.model.cricscore.CricketScore
import com.app.compose.cricket.domain.repository.ICricketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCricketScoreUseCase @Inject constructor(
    private val repository: ICricketRepository
) {
    suspend operator fun invoke(): CricketScore = withContext(Dispatchers.IO) {
        repository.getCricketScore()
    }
}