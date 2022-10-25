package com.example.demosns.application.handler

import com.example.demosns.application.usecase.CreateFollowMemberUsecase
import com.example.demosns.application.usecase.GetFollowingMembersUsecase
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait

@Component
class FollowHandler(
    private val createFollowMemberUsecase: CreateFollowMemberUsecase,
    private val getFollowingMembersUsecase: GetFollowingMembersUsecase,
) {
    suspend fun create(request: ServerRequest): ServerResponse {
        val fromMemberId = request.pathVariable("fromMemberId").toLong()
        val toMemberId = request.pathVariable("toMemberId").toLong()
        createFollowMemberUsecase.execute(fromMemberId, toMemberId)
        return ServerResponse.created(request.uri()).buildAndAwait()
    }

    suspend fun findFollowsById(request: ServerRequest): ServerResponse {
        val fromMemberId = request.pathVariable("fromMemberId").toLong()
        val followers = getFollowingMembersUsecase.execute(fromMemberId)
        return ServerResponse.ok().bodyValueAndAwait(followers)
    }
}
