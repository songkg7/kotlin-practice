package com.haril.kotlinspring.service

import com.haril.kotlinspring.domain.Student
import org.junit.jupiter.api.Test

internal class WebServiceTest {

    @Test
    internal fun name() {
        val webService = WebService()
        val studentData = Student("testUser", 20)

        val student = webService.createStudent(studentData)

        println("student = $student")
        println("name = ${student?.name}")
        println("age = ${student?.age}")
    }
}
