package domain

import java.time.LocalDateTime

data class Board(
    val id: Long,
    val title: String,
    val content: String,
    val writer: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)
