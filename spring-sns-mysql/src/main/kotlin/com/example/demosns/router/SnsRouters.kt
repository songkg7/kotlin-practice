package com.example.demosns.router

import com.example.demosns.handler.MemberHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class SnsRouters(
    val memberHandler: MemberHandler,
) {

    @Bean
    fun memberRouter() = coRouter {
        GET("/ping") {
            ServerResponse.ok().bodyValueAndAwait("pong")
        }
        POST("/member", memberHandler::create)
        GET("/members", memberHandler::findAll)

        "/member".nest {
            GET("/{id}") {
                TODO()
            }
            PUT("/{id}") {
                TODO()
            }
            DELETE("/{id}") {
                TODO()
            }
        }

        onError<Exception> { e, _ ->
            ServerResponse.badRequest().bodyValueAndAwait(e.message ?: "error")
        }
    }

}
