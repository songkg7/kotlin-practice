package com.example.springdataelasticsearch.controller

import com.example.springdataelasticsearch.domain.User
import com.example.springdataelasticsearch.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.*

@RestController
class UserController(val userService: UserService) {

    @GetMapping("/")
    fun index(): String {
        return "Hello World!"
    }

    @PostMapping("/user")
    fun createUser() {
        val user = User().apply {
            id = Random().nextLong()
            name = "John"
            age = 30
            email = ""
            created = LocalDateTime.now()
        }

        userService.saveUser(user)
    }

    @GetMapping("/users")
    fun getUsers(): List<User> {
        return userService.searchAll()
    }
}
