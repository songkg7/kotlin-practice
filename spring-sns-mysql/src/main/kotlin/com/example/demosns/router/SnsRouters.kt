package com.example.demosns.router

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@Configuration
class SnsRouters {

    @Bean
    fun memberRouter() = router {
        GET("/ping") {
            ServerResponse.ok().body(Mono.just("pong"), String::class.java)
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
    }

}
