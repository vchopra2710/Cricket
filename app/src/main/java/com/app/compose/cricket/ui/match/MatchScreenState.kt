package com.app.compose.cricket.ui.match

import com.app.compose.cricket.domain.model.cricscore.CricketScore
import com.app.compose.cricket.domain.model.currentmatches.CurrentMatch

data class MatchScreenState(
    val currentMatches: CurrentMatch? = null,
    val cricketScore: CricketScore? = null,
)
