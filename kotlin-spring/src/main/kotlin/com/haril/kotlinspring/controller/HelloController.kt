package com.haril.kotlinspring.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping
    fun home() = "home"

    @GetMapping("/hello")
    fun hello() = "hello"
}