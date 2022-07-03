package com.haril.kotlinspring.controller

import com.haril.kotlinspring.domain.Student
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping
    fun home() = "home"

    @GetMapping("/hello")
    fun hello() = "hello"

    @PostMapping("/student")
    fun create(@RequestBody student: Student): Student = Student(student.name, student.age)
}
