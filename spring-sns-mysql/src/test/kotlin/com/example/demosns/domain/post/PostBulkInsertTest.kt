package com.example.demosns.domain.post

import com.example.demosns.domain.post.entity.Post
import com.example.demosns.domain.post.repository.PostRepository
import com.navercorp.fixturemonkey.kotlin.KFixtureMonkey
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import com.navercorp.fixturemonkey.kotlin.set
import net.jqwik.api.Arbitraries
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
class PostBulkInsertTest @Autowired constructor(
    val postRepository: PostRepository,
) {

    val fixture = KFixtureMonkey.create()

    @Test
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

}
