package com.example.notebookwithkotlin.basic

import org.assertj.core.api.Assertions.assertThat
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
    internal fun infixFunctions() {
        infix fun Int.times(str: String) = str.repeat(this)
        println(2 times "Hello ")

        val pair = "Ferrari" to "Katrina"
        println(pair)

        infix fun String.onto(other: String) = Pair(this, other)
        val myPair = "McLaren" onto "Lucas"
        println(myPair)

        val sophia = Person("Sophia")
        val claudia = Person("Claudia")

        sophia likes claudia
        sophia.likedPeople.forEach { println(it.name) }
    }

    class Person(val name: String) {
        val likedPeople = mutableListOf<Person>()

        infix fun likes(other: Person) {
            likedPeople.add(other)
        }
    }

    @Test
    internal fun equality() {
        val authors = setOf("Shakespeare", "Hemingway", "Twain")
        val writers = setOf("Twain", "Shakespeare", "Hemingway")

        assertThat(authors == writers).isTrue // structural comparison
        assertThat(authors === writers).isFalse // referential comparison
    }
}