package com.app.compose.cricket.domain.model.cricscore

import com.app.compose.cricket.domain.model.Info

data class CricketScore(
    val cricketData: List<CricketData>,
    val info: Info,
    val status: String
)