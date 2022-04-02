package com.example.notebookwithkotlin.basic.enumclasses

import org.junit.jupiter.api.Test

internal class StateTest {

    @Test
    internal fun enumClasses() {
        val state = State.RUNNING
        val message = when (state) {
            State.IDLE -> "It's idle"
            State.RUNNING -> "It's running"
            State.FINISHED -> "It's finished"
        }

        println(message)
    }
}