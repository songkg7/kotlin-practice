package com.example.notebookwithkotlin.shape

import org.junit.jupiter.api.Test

internal class RectangleTest {

    @Test
    internal fun perimeter() {
        val rectangle = Rectangle(5.0, 2.0)
        println("The perimeter is ${rectangle.perimeter}")
    }
}