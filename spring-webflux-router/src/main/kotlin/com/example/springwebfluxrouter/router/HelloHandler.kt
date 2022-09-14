package com.example.springwebfluxrouter.router

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyExtractors.toFlux
import org.springframework.web.reactive.function.BodyInserters.fromProducer
import org.springframework.web.reactive.function.BodyInserters.fromPublisher
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.POST
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import kotlin.streams.asStream

@Component
class HelloHandler {

    fun routes() = route(GET("/"), this::hello)
        .andRoute(GET("/stream"), this::stream)
        .andRoute(POST("/echo"), this::echo)
        .andRoute(POST("/steam"), this::postStream)

    fun hello(request: ServerRequest) =
        ok().body(Flux.just("Hello", "World!"), String::class.java)

    fun stream(request: ServerRequest): Mono<ServerResponse> {
        val generateSequence = generateSequence(0) { it + 1 }
        val stream = Flux.fromStream(generateSequence.asStream())
            .map { mapOf("value" to it) }
        return ok().contentType(MediaType.APPLICATION_NDJSON)
            .body(fromProducer(stream, Map::class.java))
    }

    fun echo(request: ServerRequest): Mono<ServerResponse> {
        val body = request.bodyToMono(String::class.java).map { it.uppercase() }
        return ok().body(body, String::class.java)
    }

    // NOTE: why object keyword is needed?
    fun postStream(request: ServerRequest): Mono<ServerResponse> {
        val body = request.body(toFlux(object : ParameterizedTypeReference<Map<String, Int>>() {}))
        return ok().contentType(MediaType.TEXT_EVENT_STREAM)
            .body(fromPublisher(body, object : ParameterizedTypeReference<Map<String, Int>>() {}))
    }

}
