package com.app.compose.cricket.domain.model.cricscore

data class CricketData(
    val dateTimeGMT: String,
    val id: String,
    val matchType: String,
    val ms: String,
    val status: String,
    val team1: String,
    val team1Img: String?,
    val team1Score: String,
    val team2: String,
    val team2Img: String?,
    val team2Score: String
)