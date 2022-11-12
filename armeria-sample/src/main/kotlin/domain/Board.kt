package domain

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class Board(
    val id: Long,
    val title: String,
    val content: String,
    val writer: String,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime = LocalDateTime.now(),
)
