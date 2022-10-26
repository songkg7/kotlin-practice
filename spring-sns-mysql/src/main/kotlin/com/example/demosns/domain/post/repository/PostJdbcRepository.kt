package com.example.demosns.domain.post.repository

import com.example.demosns.domain.post.entity.Post
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class PostJdbcRepository(
    val namedParameterJdbcTemplate: NamedParameterJdbcTemplate,
) {
    fun bulkInsert(posts: List<Post>) {
        val sql = """
            INSERT INTO post (id, member_id, contents, create_at, create_date)
            VALUES (:id, :memberId, :contents, :createAt, :createDate)
        """.trimIndent()

        namedParameterJdbcTemplate.batchUpdate(sql, posts.map { post ->
            mapOf(
                "id" to post.id,
                "memberId" to post.memberId,
                "contents" to post.contents,
                "createAt" to post.createAt,
                "createDate" to post.createDate,
            )
        }.toTypedArray())
    }
}
