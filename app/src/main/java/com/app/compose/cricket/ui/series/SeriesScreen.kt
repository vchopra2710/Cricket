package com.app.compose.cricket.ui.series

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.compose.cricket.R
import com.app.compose.cricket.domain.model.series.SeriesData
import com.app.compose.cricket.ui.compose.Text

@Composable
fun SeriesScreen(
    viewModel: SeriesViewModel = hiltViewModel()
) = Column(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top,
) {
    val series by viewModel.series.collectAsState()
    Spacer(modifier = Modifier.height(40.dp))
    SeriesList(seriesDataList = series?.seriesData ?: listOf())
}

@Composable
private fun SeriesList(
    seriesDataList: List<SeriesData>,
) = LazyColumn(
    modifier = Modifier
        .fillMaxWidth()
        .then(Modifier.padding(8.dp))
) {
    items(seriesDataList.count()) {
        SeriesItem(seriesData = seriesDataList[it])
    }
}

@Composable
private fun SeriesItem(
    seriesData: SeriesData
) = Column(
    modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clip(RoundedCornerShape(20.dp))
        .background(Color.Gray.copy(alpha = 0.5f))
        .then(Modifier.padding(16.dp))
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
    MatchesData(
        matches = listOf(
            Pair(first = stringResource(id = R.string.series_test), second = seriesData.test),
            Pair(first = stringResource(id = R.string.series_odi), second = seriesData.odi),
            Pair(first = stringResource(id = R.string.series_t20), second = seriesData.t20),
        )
    )
}

@Composable
private fun MatchesData(matches: List<Pair<String, Int>>) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp),
    horizontalArrangement = Arrangement.SpaceBetween
) {
    matches.forEach {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = it.first,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = it.second.toString(),
                fontWeight = FontWeight.Bold,
            )
        }
        if (matches.lastIndexOf(it) != matches.size - 1) {
            Divider(
                modifier = Modifier
                    .height(40.dp)
                    .width(1.dp),
                color = Color.White
            )
        }
    }

}