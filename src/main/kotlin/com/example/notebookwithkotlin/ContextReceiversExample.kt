package com.example.notebookwithkotlin

import kotlin.random.Random

fun main() {
    printTransformedGreeting {
        this.sarcastic()
    }
}

fun String.sarcastic(): String {
    return asIterable().joinToString("") {
        if (Random.nextBoolean()) it.uppercase() else it.lowercase()
    }
}

fun printTransformedGreeting(transform: String.() -> Unit) {
    val greeting = "Hello, World!"
    val transformed = greeting.transform()
    println(transformed)
}

class Logger(val name: String) {
    fun log(s: String) {
        println("$name: $s")
    }
}