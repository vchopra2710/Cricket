package com.app.compose.cricket.usecase

import com.app.compose.cricket.domain.model.seriesdetails.SeriesInfo
import com.app.compose.cricket.domain.repository.ICricketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetSeriesDetailUseCase @Inject constructor(
    private val repository: ICricketRepository
) {
    suspend operator fun invoke(seriesId: String): SeriesInfo = withContext(Dispatchers.IO) {
        repository.getSeriesDetails(seriesId = seriesId)
    }
}