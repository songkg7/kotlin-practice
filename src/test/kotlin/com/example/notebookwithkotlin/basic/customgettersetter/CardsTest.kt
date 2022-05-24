package com.example.notebookwithkotlin.basic.customgettersetter

import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class CardsTest {

    @Test
    internal fun test() {
        val cards = Cards()

        cards.cards shouldBe emptyList()

        val card = Card(7)
        cards.add(card)

        cards.cards shouldContain card
    }
}