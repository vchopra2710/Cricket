package com.app.compose.cricket.ui.series

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.compose.cricket.R
import com.app.compose.cricket.domain.model.series.SeriesData
import com.app.compose.cricket.ui.compose.MatchesDataLayout
import com.app.compose.cricket.ui.compose.Text

@Composable
fun SeriesList(
    seriesDataList: List<SeriesData>,
    getSeriesInfo: (String) -> Unit,
    modifier: Modifier,
) = LazyColumn(
    modifier = modifier
        .fillMaxSize()
        .then(Modifier.padding(8.dp))
) {
    items(seriesDataList.count()) {
        SeriesItem(
            seriesData = seriesDataList[it],
            getSeriesInfo = getSeriesInfo,
        )
    }
}

@Composable
private fun SeriesItem(
    seriesData: SeriesData,
    getSeriesInfo: (String) -> Unit,
) = Column(
    modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clip(RoundedCornerShape(20.dp))
        .background(Color.Gray.copy(alpha = 0.5f))
        .then(Modifier.padding(16.dp))
        .clickable { getSeriesInfo(seriesData.id) }
) {
    Text(
        text = seriesData.name,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "${seriesData.startDate} - ${seriesData.endDate}",
        fontWeight = FontWeight.SemiBold,
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = stringResource(id = R.string.series_matches, seriesData.matches))
    Spacer(modifier = Modifier.height(8.dp))
    MatchesDataLayout(
        matches = listOf(
            Pair(first = stringResource(id = R.string.series_test), second = seriesData.test),
            Pair(first = stringResource(id = R.string.series_odi), second = seriesData.odi),
            Pair(first = stringResource(id = R.string.series_t20), second = seriesData.t20),
        )
    )
}