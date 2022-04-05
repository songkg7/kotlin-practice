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

    @Test
    internal fun partition() {
        val numbers = listOf(1, -2, 3, -4, 5, -6)
        val evenOdd = numbers.partition { it % 2 == 0 }
        val (positive, negative) = numbers.partition { it > 0 }

        println(numbers)
        println(evenOdd)
        println(positive)
        println(negative)
    }

    @Test
    internal fun flatMap() {
        val strings1 = listOf("entrance", "point", "terrible", "rob", "hear")
        val strings2 = listOf("smoke", "law", "wander", "arrest", "kitchen")
        val words = listOf(strings1, strings2)

        val mapWords = words.map { it }
        val flatMapWords = words.flatMap { it }

        println("mapWords = $mapWords")
        println("flatMapWords = $flatMapWords")
    }

    @Test
    internal fun mapElementAccess() {
        val map = mapOf("key" to 42)

        val value1 = map["key"]
        val value2 = map["key2"]

        val value3 = map.getValue("key")

        val mapWithDefault = map.withDefault { it.length }
        val value4 = mapWithDefault.getValue("key2")

        try {
            map.getValue("anotherKey")
        } catch (e: NoSuchElementException) {
            println("Message: $e")
        }

        println("value1 = $value1")
        println("value2 = $value2")
        println("value3 = $value3")
        println("value4 = $value4")
    }

    @Test
    internal fun let() {
        // let scope function 은 가장 마지막 expression 의 결과값을 return
        val isEmpty = "test".let {
            println(it)
            it.isEmpty()
        }

        println("isEmpty = $isEmpty")
    }

    @Test
    internal fun run() {
        val person = Person("sophia", "New York", "123-1234-1234")
        val name = person.run {
            println("run")
            name
        }

        println(name)
    }
}