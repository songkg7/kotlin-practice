package com.example.demosns.application.handler

import com.example.demosns.domain.member.dto.CreateMemberCommand
import com.example.demosns.domain.member.dto.UpdateMemberCommand
import com.example.demosns.domain.member.service.MemberReadService
import com.example.demosns.domain.member.service.MemberWriteService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class MemberHandler(
    private val memberWriteService: MemberWriteService,
    private val memberReadService: MemberReadService,
) {
    suspend fun create(request: ServerRequest): ServerResponse {
        val body = request.awaitBody<CreateMemberCommand>()
        memberWriteService.create(body)
        return ServerResponse.created(request.uri()).buildAndAwait()
    }

    suspend fun findAll(request: ServerRequest): ServerResponse {
        val members = memberReadService.findAll()
        return ServerResponse.ok().bodyValueAndAwait(members)
    }

    suspend fun findById(request: ServerRequest): ServerResponse {
        val id = request.pathVariable("id").toLong()
        val member = memberReadService.findById(id)
        return ServerResponse.ok().bodyValueAndAwait(member)
    }

    suspend fun update(request: ServerRequest): ServerResponse {
        val id = request.pathVariable("id").toLong()
        val body = request.awaitBody<UpdateMemberCommand>()
        memberWriteService.changeNickname(id, body.nickname)
        return ServerResponse.ok().buildAndAwait()
    }
}
