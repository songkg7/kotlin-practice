package com.example.notebookwithkotlin.basic.customgettersetter

class Cards {
    private val _cards: MutableList<Card> = mutableListOf()
    val cards: List<Card>
        get() = _cards

    fun add(card: Card) {
        _cards += card
    }
}

class Card(val value: Int){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Card

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }
}
