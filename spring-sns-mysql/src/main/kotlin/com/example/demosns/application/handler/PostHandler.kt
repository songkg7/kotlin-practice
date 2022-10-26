package com.example.demosns.application.handler

import com.example.demosns.domain.post.dto.PostCommand
import com.example.demosns.domain.post.service.PostWriteService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.buildAndAwait

@Component
class PostHandler(
    private val postWriteService: PostWriteService,
) {

    suspend fun createPost(serverRequest: ServerRequest): ServerResponse {
        val postCommand = serverRequest.awaitBody<PostCommand>()
        postWriteService.create(postCommand)
        return ServerResponse.created(serverRequest.uri()).buildAndAwait()
    }

}
