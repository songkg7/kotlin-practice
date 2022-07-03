package com.haril.kotlinspring.service

import com.haril.kotlinspring.domain.Student
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

class WebService {

    fun createStudent(): Student? {
        val webClient = WebClient.builder().baseUrl("http://localhost:8080").build()

        return webClient.post()
            .uri("/student")
            .contentType(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono<Student>()
            .block()
    }

}
