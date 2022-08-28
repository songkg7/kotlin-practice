package com.example.springmvc.service

import com.example.springmvc.converter.CarrierConverter
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class CarrierService(private val webClient: WebClient) {

    fun bypass(converter: CarrierConverter) = Mono.just(converter.convert())
}
