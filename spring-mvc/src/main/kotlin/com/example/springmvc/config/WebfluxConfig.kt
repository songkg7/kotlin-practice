package com.example.springmvc.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebfluxConfig {

    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .build()
    }
}
