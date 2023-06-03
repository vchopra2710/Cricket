package com.app.compose.cricket.ui.series

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.compose.cricket.R
import com.app.compose.cricket.domain.model.seriesdetails.SeriesDetail
import com.app.compose.cricket.domain.model.seriesdetails.SeriesInfoDetail
import com.app.compose.cricket.domain.model.seriesdetails.SeriesMatch
import com.app.compose.cricket.ui.compose.MatchesDataLayout
import com.app.compose.cricket.ui.compose.ScoreRowView
import com.app.compose.cricket.ui.compose.Text

@Composable
fun SeriesInfoLayout(seriesDetail: SeriesDetail?) = Column(
    modifier = Modifier
        .fillMaxHeight()
        .background(Color.Black)
        .padding(8.dp)
        .background(Color.Gray.copy(alpha = 0.5f))
        .statusBarsPadding()
        .then(Modifier.padding(16.dp)),
) {
    val detail: SeriesInfoDetail? = seriesDetail?.info
    val matchList: List<SeriesMatch> = seriesDetail?.matchList ?: listOf()
    Text(
        text = detail?.name.toString(),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "${detail?.startDate} - ${detail?.endDate}",
        fontWeight = FontWeight.SemiBold,
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = stringResource(id = R.string.series_matches, detail?.matches ?: 0))
    Spacer(modifier = Modifier.height(8.dp))
    MatchesDataLayout(
        matches = listOf(
            Pair(first = stringResource(id = R.string.series_test), second = detail?.test ?: 0),
            Pair(first = stringResource(id = R.string.series_odi), second = detail?.odi ?: 0),
            Pair(first = stringResource(id = R.string.series_t20), second = detail?.t20 ?: 0),
        )
    )
    Spacer(modifier = Modifier.height(8.dp))
    MatchList(matchList = matchList)
}

@Composable
private fun MatchList(matchList: List<SeriesMatch>) = LazyColumn {
    items(matchList.count()) {
        val match = matchList[it]
        MatchListItem(match = match)
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
private fun MatchListItem(match: SeriesMatch) = Column(
    modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(20.dp))
        .background(Color.White)
        .then(Modifier.padding(16.dp))
) {
    Text(
        text = match.name,
        color = Color.Black,
        fontWeight = FontWeight.SemiBold,
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = match.venue,
        color = Color.Black,
    )
    Spacer(modifier = Modifier.height(4.dp))
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = match.dateTimeGMT,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Divider(
            modifier = Modifier
                .height(16.dp)
                .width(1.dp),
            color = Color.Black
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = match.matchType.uppercase(),
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    match.teamInfo.forEach {
        ScoreRowView(
            image = it.img,
            name = it.name,
            score = "",
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(4.dp))
    }

    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = match.status,
        color = Color.Black,
    )
}