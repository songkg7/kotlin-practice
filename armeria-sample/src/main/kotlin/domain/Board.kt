package domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.linecorp.armeria.server.annotation.Description
import java.time.LocalDateTime

infix fun String.hasOwnerShip(board: Board) = this == board.writer

data class Board(
    val id: Long,
    val title: String,
    val content: String,
    val writer: String,

    // FIXME: hide this field from DocService
    // e.g. separate dto and domain, only define this field in domain.
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Description(value = "기본적으로 생성되므로 직접 입력하지 않아도 됩니다.")
    val createdAt: LocalDateTime = LocalDateTime.now(),
)
