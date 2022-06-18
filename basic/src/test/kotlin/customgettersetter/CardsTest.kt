package customgettersetter

import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CardsTest {

    @Test
    @DisplayName("Backing properties 를 사용하여 객체 내부에서는 수정가능하지만 외부에서는 수정 불가능하게 한다.")
    internal fun test() {
        val cards = Cards()

        cards.cards shouldBe emptyList()

        val card = Card(7)
        cards.add(card)

        cards.cards shouldContain card
    }
}