import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class PairTest : DescribeSpec({

    describe("Pair") {
        it("should be able to be destructured") {
            val (a, b) = Pair(1, 2)
            a shouldBe 1
            b shouldBe 2
        }

        it("should be able to be destructured with infix notation") {
            val (a, b) = 1 to 2
            a shouldBe 1
            b shouldBe 2
        }

    }
})
