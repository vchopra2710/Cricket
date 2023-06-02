package com.app.compose.cricket.ui.match

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.app.compose.cricket.domain.model.cricscore.CricketData
import com.app.compose.cricket.ui.compose.ScoreRowView
import com.app.compose.cricket.ui.compose.Text

@Composable
fun CricketScoreLayout(
    cricketData: List<CricketData>
) = LazyColumn(
    modifier = Modifier
        .fillMaxWidth()
        .then(Modifier.padding(8.dp))
) {
    items(cricketData.count()) {
        CricketScoreItem(cricketData[it])
    }
}

@Composable
private fun CricketScoreItem(
    data: CricketData,
) = Column(
    modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clip(RoundedCornerShape(20.dp))
        .background(Color.Gray.copy(alpha = 0.5f))
        .then(Modifier.padding(16.dp))
) {
    val teamInfo = listOf(
        Triple(data.team1Img, data.team1, data.team1Score),
        Triple(data.team2Img, data.team2, data.team2Score)
    )
    CricketScoreTeamView(
        teamInfo = teamInfo,
        status = data.status,
        date = data.dateTimeGMT,
        matchType = data.matchType,
    )
}

@Composable
private fun CricketScoreTeamView(
    teamInfo: List<Triple<String?, String, String>>,
    status: String,
    date: String,
    matchType: String,
) = Column {
    teamInfo.forEach { (image, name, score) ->
        ScoreRowView(
            image = image,
            name = name,
            score = score,
        )

        Spacer(modifier = Modifier.height(16.dp))
    }

    Text(text = matchType.uppercase())
    Spacer(modifier = Modifier.height(4.dp))
    Text(text = date)
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = status,
        fontWeight = FontWeight.SemiBold,
    )
}