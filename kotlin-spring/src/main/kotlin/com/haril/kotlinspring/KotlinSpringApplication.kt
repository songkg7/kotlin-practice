package com.haril.kotlinspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpring

fun main(args: Array<String>) {
    runApplication<KotlinSpring>(*args)
}