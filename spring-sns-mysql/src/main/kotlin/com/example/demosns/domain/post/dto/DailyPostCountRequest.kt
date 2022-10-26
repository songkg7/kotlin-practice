package com.example.demosns.domain.post.dto

import java.time.LocalDate

class DailyPostCountRequest(
    val memberId: Long,
    val startDate: LocalDate,
    val endDate: LocalDate,
)
