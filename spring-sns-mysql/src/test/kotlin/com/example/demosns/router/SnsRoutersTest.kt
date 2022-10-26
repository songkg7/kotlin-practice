package com.example.demosns.router

import com.example.demosns.application.handler.FollowHandler
import com.example.demosns.application.handler.MemberHandler
import com.example.demosns.application.handler.PostHandler
import com.example.demosns.application.usecase.CreateFollowMemberUsecase
import com.example.demosns.application.usecase.GetFollowingMembersUsecase
import com.example.demosns.domain.member.service.MemberReadService
import com.example.demosns.domain.member.service.MemberWriteService
import com.example.demosns.domain.post.service.PostReadService
import com.example.demosns.domain.post.service.PostWriteService
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import io.mockk.mockk
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@WebFluxTest
internal class SnsRoutersTest : DescribeSpec() {

    private var memberWriteService = mockk<MemberWriteService>()
    private var memberReadService = mockk<MemberReadService>()
    private var createFollowMemberUsecase = mockk<CreateFollowMemberUsecase>()
    private var getFollowingMembersUsecase = mockk<GetFollowingMembersUsecase>()
    private var postWriteService = mockk<PostWriteService>()
    private var postReadService = mockk<PostReadService>()
    private lateinit var webTestClient: WebTestClient

    init {
        beforeTest {
            webTestClient = WebTestClient.bindToRouterFunction(
                SnsRouters(
                    MemberHandler(
                        memberWriteService,
                        memberReadService
                    ),
                    FollowHandler(createFollowMemberUsecase, getFollowingMembersUsecase),
                    PostHandler(postWriteService, postReadService)
                ).memberRouter()
            ).build()
        }

        describe("GET /ping") {
            it("returns pong") {
                webTestClient.get()
                    .uri("/ping")
                    .exchange()
                    .expectStatus().isOk
                    .expectBody(String::class.java)
                    .isEqualTo("pong")
            }
        }

        describe("POST /member") {
            it("returns 201") {

                every { memberWriteService.create(any()) } returns Unit

                webTestClient.post()
                    .uri("/member")
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(
                        """
                        {
                            "nickname": "test",
                            "birthday": "1994-07-07",
                            "email": "test@email.com"
                        }
                        """.trimIndent()
                    )
                    .exchange()
                    .expectStatus().isCreated
            }
        }

    }
}
