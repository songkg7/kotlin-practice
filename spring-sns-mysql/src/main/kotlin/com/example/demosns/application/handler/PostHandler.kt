package com.example.demosns.application.handler

import com.example.demosns.domain.post.dto.DailyPostCountRequest
import com.example.demosns.domain.post.dto.PostCommand
import com.example.demosns.domain.post.service.PostReadService
import com.example.demosns.domain.post.service.PostWriteService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class PostHandler(
    private val postWriteService: PostWriteService,
    private val postReadService: PostReadService,
) {

    suspend fun createPost(serverRequest: ServerRequest): ServerResponse {
        val postCommand = serverRequest.awaitBody<PostCommand>()
        postWriteService.create(postCommand)
        return ServerResponse.created(serverRequest.uri()).buildAndAwait()
    }

    suspend fun getDailyPostCount(serverRequest: ServerRequest): ServerResponse {
        val request = serverRequest.awaitBody<DailyPostCountRequest>()
        val dailyPostCount = postReadService.getDailyPostCounts(request)
        return ServerResponse.ok().bodyValueAndAwait(dailyPostCount)
    }

}
