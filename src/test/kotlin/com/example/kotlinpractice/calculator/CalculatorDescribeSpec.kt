package com.example.kotlinpractice.calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class CalculatorDescribeSpec : DescribeSpec({

    describe("calculator") {
        context("1 더하기 1을 하면") {
            it("해당 식의 결과값이 반환된다.") {
                val result = sum(1, 1)
                result shouldBe 2
            }
        }
    }
})