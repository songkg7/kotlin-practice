package com.example.demosns.domain.post

import com.example.demosns.domain.post.entity.Post
import com.example.demosns.domain.post.repository.PostJdbcRepository
import com.example.demosns.domain.post.repository.PostRepository
import com.navercorp.fixturemonkey.kotlin.KFixtureMonkey
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import com.navercorp.fixturemonkey.kotlin.set
import net.jqwik.api.Arbitraries
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
class PostBulkInsertTest @Autowired constructor(
    val postRepository: PostRepository,
    val postJdbcRepository: PostJdbcRepository,
) {

    val fixture = KFixtureMonkey.create()

    @Test
    @Disabled("This test is very slow")
    fun `bulk insert`() {
        val posts = fixture.giveMeBuilder<Post>()
            .set(Post::id, null) // id is auto-generated
            .set(Post::memberId, 1L)
            .set(
                Post::createDate,
                Arbitraries.integers().between(1, 30).map { LocalDate.of(2022, 10, it) })
            .sampleList(100_0000)

        postRepository.saveAll(posts)
    }

    @Test
    @Disabled("This test is very slow")
    @DisplayName("bulk insert with jdbc about 60 seconds")
    fun jdbcBulkInsert() {
        val posts = generateSequence(1L) { it + 1 }
            .take(100_0000)
            .map { id ->
                fixture.giveMeBuilder<Post>()
                    .set(Post::id, id)
                    .set(Post::memberId, 1L)
                    .set(Post::createDate, LocalDate.of(2022, 10, 1 randomly 30))
                    .sample()
            }
            .toList()

        postJdbcRepository.bulkInsert(posts)
    }

    private infix fun Int.randomly(to: Int): Int {
        return Math.random().toInt() * (to - this) + this
    }

}
