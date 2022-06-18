package customgettersetter

class Cards {
    private val _cards: MutableList<customgettersetter.Card> = mutableListOf()
    val cards: List<customgettersetter.Card>
        get() = _cards

    fun add(card: customgettersetter.Card) {
        _cards += card
    }
}

class Card(val value: Int)
