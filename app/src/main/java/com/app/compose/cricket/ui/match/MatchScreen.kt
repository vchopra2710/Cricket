package com.app.compose.cricket.ui.match

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.compose.cricket.domain.model.currentmatches.Data
import com.app.compose.cricket.domain.model.currentmatches.Score
import com.app.compose.cricket.domain.model.currentmatches.TeamInfo
import com.app.compose.cricket.ui.compose.ScoreRowView
import com.app.compose.cricket.ui.compose.Text
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@Composable
fun MatchScreen(
    viewModel: MatchViewModel = hiltViewModel(),
) = Column(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top,
) {
    val state by viewModel.state.collectAsState()
    Spacer(modifier = Modifier.height(40.dp))
    CurrentMatchesHorizontalPager(
        currentMatch = state.currentMatches?.data ?: listOf()
    )
    Spacer(modifier = Modifier.height(40.dp))
    CricketScoreLayout(
        cricketData = state.cricketScore?.cricketData ?: listOf()
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun CurrentMatchesHorizontalPager(
    currentMatch: List<Data>
) = Column(
    horizontalAlignment = Alignment.CenterHorizontally
) {
    val state: PagerState = rememberPagerState()
    HorizontalPager(
        state = state,
        count = currentMatch.count(),
        modifier = Modifier
            .fillMaxWidth()
            .then(Modifier.padding(8.dp))
    ) {
        CurrentMatchItem(data = currentMatch[it])
    }

    Spacer(modifier = Modifier.height(8.dp))

    HorizontalPagerIndicator(
        pagerState = state,
        activeColor = Color.White,
    )
}

@Composable
private fun CurrentMatchItem(
    data: Data
) = Column(
    modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clip(RoundedCornerShape(20.dp))
        .background(Color.Gray.copy(alpha = 0.5f))
        .then(Modifier.padding(16.dp))
) {
    Text(text = data.name)

    Spacer(modifier = Modifier.height(8.dp))

    TeamView(
        teamInfoList = data.teamInfo,
        scoreList = data.score,
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(data.status)
}


@Composable
private fun TeamView(
    teamInfoList: List<TeamInfo>,
    scoreList: List<Score>,
) = Column(
    modifier = Modifier.fillMaxWidth(),
) {
    val sortedScoreList = scoreList.sortedBy { it.inning }

    teamInfoList.sortedBy { it.name }.forEach { teamInfo ->

        val filteredScoreList = sortedScoreList.filter {
            it.inning.contains(teamInfo.name)
        }

        TeamNameAndIconItem(
            team = teamInfo,
            scoreList = filteredScoreList,
        )

        if (teamInfoList.indexOf(teamInfo) < teamInfoList.size - 1) {
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
private fun TeamNameAndIconItem(
    team: TeamInfo,
    scoreList: List<Score>,
) {
    val score = scoreList.joinToString(separator = " & ") { score ->
        "${score.run}-${score.wicket} (${score.over})"
    }
    ScoreRowView(
        image = team.img,
        name = team.shortname,
        score = score,
    )
}