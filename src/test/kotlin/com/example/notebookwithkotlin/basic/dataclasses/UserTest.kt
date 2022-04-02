package com.example.notebookwithkotlin.basic.dataclasses

import org.junit.jupiter.api.Test

internal class UserTest {

    @Test
    internal fun dataClasses() {
        val user = User("Alex", 1)
        println(user)

        val secondUser = User("Alex", 1)
        val thirdUser = User("Max", 2)

        println("user == secondUser: ${user == secondUser}")
        println("user == thirdUser: ${user == thirdUser}")

        println(user.hashCode())
        println(secondUser.hashCode())
        println(thirdUser.hashCode())

        println(user.copy())
        println(user === user.copy())
        println(user.copy("Max"))
        println(user.copy(id = 3))

        println("user: ${user.component1()}")
        println("id: ${user.component2()}")
    }
}