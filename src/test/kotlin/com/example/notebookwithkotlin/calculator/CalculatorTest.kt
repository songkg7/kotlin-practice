package com.example.notebookwithkotlin.calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    @Test
    internal fun sum() {
        val sum = sum(1, 2)
        sum shouldBe 3
    }
}