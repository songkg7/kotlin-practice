package com.example.springwebflux.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.stream.Stream
import kotlin.streams.asStream

@RestController
class HelloController {

    @GetMapping("/mono")
    fun helloMono() = Mono.just("hello")

    @GetMapping("/flux")
    fun helloFlux() = Flux.just("hello", "world")

    @GetMapping("/flux/int")
    fun intFlux(): Flux<Int> {
        val intStream = Stream.of(1, 2, 3, 4, 5)

        return Flux.fromStream(intStream)
    }

    @GetMapping("/flux/stream")
    fun streamFlux(): Flux<Map<String, Int>> {
        val stream = generateSequence(0) { it + 2 }.asStream()
        return Flux.fromStream(stream.limit(5)).map { mapOf("value" to it) }
    }

    @GetMapping("/flux/infinity")
    fun infinityStreamFlux(): Flux<Map<String, Int>> {
        val stream = generateSequence(0) { it + 1 }.asStream()
        return Flux.fromStream(stream).map { mapOf("value" to it) }
    }

    @GetMapping("/flux/duration")
    fun durationStream(): Flux<Map<String, Long>> {
        val stream = generateSequence(0) { it + 1 }.asStream()
        return Flux.fromStream(stream).zipWith(Flux.interval(Duration.ofSeconds(2)))
            .map { mapOf() }
    }
}
