package com.example.notebookwithkotlin.basic.generic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MutableStackTest {

    @Test
    internal fun initialize() {
        val stack = MutableStack("sorrow", "amongst", "along", "redden", "rule")

        println(stack)
        assertThat(stack.size()).isEqualTo(5)
    }

    @Test
    internal fun push() {
        val stack = MutableStack(1, 2, 3, 4, 5)

        stack.push(6)

        println(stack)
        assertThat(stack.size()).isEqualTo(6)
    }

    @Test
    internal fun peek() {
        val stack = MutableStack(1, 2, 3, 4, 5)

        val peek = stack.peek()

        assertThat(peek).isEqualTo(5)
        assertThat(stack.size()).isEqualTo(5)
    }

    @Test
    internal fun pop() {
        val stack = MutableStack(1, 2, 3, 4, 5)

        val pop = stack.pop()

        assertThat(pop).isEqualTo(5)
        assertThat(stack.size()).isEqualTo(4)
    }

    @Test
    internal fun isEmpty() {
        val stack = MutableStack(667.93, 702.66, 661.35, 148.08, 271.99)

        val empty = stack.isEmpty()
        assertThat(empty).isFalse
    }

    @Test
    internal fun infix_operator() {
        val stack = MutableStack(1, 2, 3, 4, 5)

        stack plus 6
        stack + 7
        println(stack)
        assertThat(stack.size()).isEqualTo(7)
    }

    @Test
    internal fun iterator() {
        val stack = MutableStack("grace", "shelf", "happy", "coin", "figure")

        for (word in stack) {
            println(word)
        }
    }
}