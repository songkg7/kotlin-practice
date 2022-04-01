package com.example.notebookwithkotlin

import org.junit.jupiter.api.Test

class BasicTest {

    @Test
    internal fun stringFlatMap() {
        val flatMap = listOf("total", "scorn", "debt", "forget", "ear")
            .flatMap { it.toList() }
            .sortedDescending()

        println("flatMap = $flatMap")
    }

    @Test
    internal fun sum() {

    }
}