package infix

import org.junit.jupiter.api.Test

internal class PersonTest {

    @Test
    internal fun infix() {
        val sophia = Person("Sophia")
        val claudia = Person("Claudia")

        sophia likes claudia

        sophia.likedPeople.forEach { println(it.name) }
    }
}