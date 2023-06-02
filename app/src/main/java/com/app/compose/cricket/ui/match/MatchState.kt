package com.app.compose.cricket.ui.match

import com.app.compose.cricket.domain.model.currentmatches.CurrentMatch

data class MatchState(
    val currentMatch: CurrentMatch? = null
)
