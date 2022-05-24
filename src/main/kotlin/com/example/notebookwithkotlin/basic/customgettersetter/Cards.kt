package com.example.notebookwithkotlin.basic.customgettersetter

class Cards {
    private val _cards: MutableList<Card> = mutableListOf()
    val cards: List<Card>
        get() = _cards

    fun add(card: Card) {
        _cards += card
    }
}

class Card(val value: Int)
