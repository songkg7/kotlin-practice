package com.example.notebookwithkotlin.basic

import com.example.notebookwithkotlin.basic.collections.Person
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
    }

    @Test
    internal fun equality() {
        val authors = setOf("Shakespeare", "Hemingway", "Twain")
        val writers = setOf("Twain", "Shakespeare", "Hemingway")

        assertThat(authors == writers).isTrue // structural comparison
        assertThat(authors === writers).isFalse // referential comparison
    }

    @Test
    internal fun associateBy() {
        val people = listOf(
            Person("John", "Boston", "+1-888-123456"),
            Person("Sarah", "Munich", "+49-777-789123"),
            Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
            Person("Vasilisa", "Saint-Petersburg", "+7-999-123456"))

        val phoneBook = people.associateBy { it.phone }
        val cityBook = people.associateBy(Person::phone, Person::city)
        val peopleCities = people.groupBy(Person::city, Person::name)
        val lastPersonCity = people.associateBy(Person::city, Person::name)

        println(phoneBook)
        println(cityBook)
        println(peopleCities)
        println(lastPersonCity)
    }
}