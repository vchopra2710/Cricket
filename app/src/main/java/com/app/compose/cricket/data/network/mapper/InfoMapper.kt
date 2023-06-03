package com.app.compose.cricket.data.network.mapper

import com.app.compose.cricket.data.network.model.InfoDto
import com.app.compose.cricket.domain.model.Info

fun InfoDto.toInfoDomain(): Info = Info(
    hitsToday = hitsToday,
    hitsUsed = hitsUsed,
    hitsLimit = hitsLimit,
    credits = credits,
    server = server,
    offsetRows = offsetRows,
    totalRows = totalRows,
    queryTime = queryTime,
    s = s,
    cache = cache,
)