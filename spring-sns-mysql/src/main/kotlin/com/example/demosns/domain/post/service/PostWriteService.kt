package com.example.demosns.domain.post.service

import com.example.demosns.domain.post.dto.PostCommand
import com.example.demosns.domain.post.entity.Post
import com.example.demosns.domain.post.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostWriteService(
    private val postRepository: PostRepository
) {

    fun create(postCommand: PostCommand) {
        val post = Post(
            contents = postCommand.contents,
            memberId = postCommand.memberId
        )
        postRepository.save(post)
    }

}
