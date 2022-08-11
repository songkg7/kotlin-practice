package com.haril.kotlinspringjpa.student.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AppController {

    @GetMapping
    fun home() = "home"
}
