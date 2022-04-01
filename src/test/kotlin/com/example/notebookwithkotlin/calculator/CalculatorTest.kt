package com.example.notebookwithkotlin.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    @Test
    internal fun sum() {
        val calculator = Calculator()

        val result = calculator.sum(10, 5)

        assertThat(result).isEqualTo(15)
    }
}