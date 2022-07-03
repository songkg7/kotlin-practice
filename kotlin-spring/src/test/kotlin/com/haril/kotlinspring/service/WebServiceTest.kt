package com.haril.kotlinspring.service

import org.junit.jupiter.api.Test

internal class WebServiceTest {

    @Test
    internal fun name() {
        val webService = WebService()

        val student = webService.createStudent()

        println("student = $student")
        println("name = ${student?.name}")
        println("age = ${student?.age}")
    }
}
