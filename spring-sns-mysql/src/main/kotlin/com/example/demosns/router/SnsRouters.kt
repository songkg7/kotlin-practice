package com.example.demosns.router

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class SnsRouters {

    @Bean
    fun memberRouter() = coRouter {
        GET("/ping") {
            ServerResponse.ok().bodyValueAndAwait("pong")
        }
        "/member".nest {
            GET("/list") {
                TODO()
            }
            GET("/{id}") {
                TODO()
            }
            POST("/join") {
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
