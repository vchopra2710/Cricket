package com.app.compose.cricket.usecase

import com.app.compose.cricket.domain.model.series.Series
import com.app.compose.cricket.domain.repository.ICricketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetSeriesListUseCase @Inject constructor(
    private val repository: ICricketRepository
) {
    suspend operator fun invoke(): Series = withContext(Dispatchers.IO) {
        repository.getSeries()
    }
}