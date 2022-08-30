package com.example.springsecurity.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class HelloController {

    @GetMapping("/mono")
    fun helloMono(): Mono<String> {
        return Mono.just("hello")
    }

    @GetMapping("/flux")
    fun helloFlux() = Flux.just("hello", "world")

}
