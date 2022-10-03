package com.example.springdataelasticsearch.controller

import com.example.springdataelasticsearch.domain.User
import com.example.springdataelasticsearch.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class UserController(val userService: UserService) {

    @GetMapping("/")
    fun hello() = "Hello World!"

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody user: User) = userService.saveUser(user)

    @GetMapping("/users")
    fun getUsers() = userService.searchAll()

    @DeleteMapping("/users")
    fun deleteAll() = userService.deleteAll()
}
