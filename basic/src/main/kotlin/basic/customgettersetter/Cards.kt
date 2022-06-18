package basic.customgettersetter

class Cards {
    private val _cards: MutableList<basic.customgettersetter.Card> = mutableListOf()
    val cards: List<basic.customgettersetter.Card>
        get() = _cards

    fun add(card: basic.customgettersetter.Card) {
        _cards += card
    }
}

class Card(val value: Int)
