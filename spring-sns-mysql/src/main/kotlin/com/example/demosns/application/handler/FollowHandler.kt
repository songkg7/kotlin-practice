package com.example.demosns.application.handler

import com.example.demosns.application.usecase.CreateFollowMemberUsecase
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait

@Component
class FollowHandler(
    private val createFollowMemberUsecase: CreateFollowMemberUsecase
) {
    suspend fun create(request: ServerRequest): ServerResponse {
        val fromMemberId = request.pathVariable("fromMemberId").toLong()
        val toMemberId = request.pathVariable("toMemberId").toLong()
        createFollowMemberUsecase.execute(fromMemberId, toMemberId)
        return ServerResponse.created(request.uri()).buildAndAwait()
    }
}
