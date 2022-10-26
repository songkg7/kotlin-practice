package com.example.demosns.domain.post.dto

import java.time.LocalDate

class DailyPostCount(
    val memberId: Long,
    val date: LocalDate,
    val count: Long,
) {
}
