package builder

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class FoodOrderTest: DescribeSpec({

    describe("builder pattern") {
        it("usage") {
            val order = FoodOrder.Builder()
                .bread("white bread")
                .condiments("mayo")
                .meat("chicken")
                .cheese("cheddar")
                .vegetables("lettuce")
                .build()

            with(order) {
                bread shouldBe "white bread"
                condiments shouldBe "mayo"
                meat shouldBe "chicken"
                cheese shouldBe "cheddar"
                vegetables shouldBe "lettuce"
            }
        }
    }
})
