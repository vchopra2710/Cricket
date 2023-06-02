package com.app.compose.cricket.domain.model.currentmatches

data class CurrentMatch(
    val apikey: String,
    val data: List<Data>,
    val info: Info,
    val status: String
)