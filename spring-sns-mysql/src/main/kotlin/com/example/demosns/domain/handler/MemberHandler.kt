package com.example.demosns.domain.handler

import com.example.demosns.domain.member.dto.RegistMemberCommand
import com.example.demosns.domain.member.service.MemberWriteService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class MemberHandler(
    val memberWriteService: MemberWriteService,
) {
    suspend fun create(request: ServerRequest): ServerResponse {
        val body = request.awaitBody<RegistMemberCommand>()
        memberWriteService.create(body)
        return ServerResponse.created(request.uri()).buildAndAwait()
    }

    suspend fun findAll(request: ServerRequest): ServerResponse {
        val members = memberWriteService.findAll()
        return ServerResponse.ok().bodyValueAndAwait(members)
    }
}
