package com.app.compose.cricket.domain.model.currentmatches

data class Info(
    val hitsToday: Int,
    val hitsUsed: Int,
    val hitsLimit: Int,
    val credits: Int,
    val server: Int,
    val offsetRows: Int,
    val totalRows: Int,
    val queryTime: Double,
    val s: Int,
    val cache: Int
)