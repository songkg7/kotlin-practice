package com.example.notebookwithkotlin.basic.lambdas

import org.junit.jupiter.api.Test

internal class LambdasTest {

    @Test
    internal fun lambdas() {
        val lambdas = Lambdas()

        println(lambdas.upperCase1("hello"))
        println(lambdas.upperCase2("hello"))
        println(lambdas.upperCase3("hello"))
        println(lambdas.upperCase4("hello"))
        println(lambdas.upperCase5("hello"))
    }
}