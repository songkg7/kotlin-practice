package com.example.demosns.domain.handler

import com.example.demosns.domain.member.dto.RegistMemberCommand
import com.example.demosns.domain.member.service.MemberWriteService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.buildAndAwait

@Component
class MemberHandler(
    val memberWriteService: MemberWriteService,
) {
    suspend fun create(request: ServerRequest): ServerResponse {
        val body = request.awaitBody<RegistMemberCommand>()
        memberWriteService.create(body)
        return ServerResponse.ok().buildAndAwait()
    }
}
