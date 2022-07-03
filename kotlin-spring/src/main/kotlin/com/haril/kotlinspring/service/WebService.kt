package com.haril.kotlinspring.service

import com.haril.kotlinspring.domain.Student
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

class WebService {

    fun createStudent(student: Student): Student? {
        val webClient = WebClient.builder().baseUrl("http://localhost:8080").build()

        return webClient.post()
            .uri("/student")
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(student), Student::class.java)
            .retrieve()
            .bodyToMono<Student>()
            .block()
    }

}
