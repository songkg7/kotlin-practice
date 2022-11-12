package dto

data class BoardDeleteRequest(
    val id: Long,
    val writer: String,
)
