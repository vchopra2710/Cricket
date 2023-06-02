package com.app.compose.cricket.data.network.mapper

import com.app.compose.cricket.data.network.model.series.SeriesDataDto
import com.app.compose.cricket.data.network.model.series.SeriesDto
import com.app.compose.cricket.domain.model.series.Series
import com.app.compose.cricket.domain.model.series.SeriesData

fun SeriesDto.toDomain(): Series = Series(
    seriesData = seriesData.toSeriesDataDomain(),
    seriesInfo = seriesInfo.toInfoDomain(),
    status = status,
)

private fun List<SeriesDataDto>.toSeriesDataDomain() = this.map {
    SeriesData(
        endDate = it.endDate,
        id = it.id,
        matches = it.matches,
        name = it.name,
        odi = it.odi,
        squads = it.squads,
        startDate = it.startDate,
        t20 = it.t20,
        test = it.test,
    )
}