package com.example.notebookwithkotlin.basic.delegation

import org.junit.jupiter.api.Test

internal class DelegationPatternTest {

    @Test
    internal fun delegate() {
        val tomAraya = TomAraya("Thrash Metal")
        tomAraya.makeSound()

        val elvisPresley = ElvisPresley("Dancin' to the Jailhouse Rock.")
        elvisPresley.makeSound()
    }
}