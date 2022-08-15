package enums

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class GarbageTypeTest : DescribeSpec({
    describe("main") {
        it("print") {
            println(GarbageType.PLASTIC.koName)
            println(GarbageType.GLASS.koName)
            println(GarbageType.IRON.koName)
        }

        it("iterator") {
            val arrays = enumValues<GarbageType>()
            val map = arrays
                .filter { it.koName == "플라스틱" }
                .map { it.koName }
            println("map = $map")

            val type = enumValueOf<GarbageType>("PLASTIC")
            println(type.koName)

            type shouldBe GarbageType.PLASTIC
        }

        describe("calculate price") {
            it("plastic") {
                val pair = 20 to GarbageType.PLASTIC

                val totalPrice = sell(pair)
                println("총 가격은 $totalPrice 입니다.")

                totalPrice shouldBe 3000
            }

            it("glass") {
                val pair = 30 to GarbageType.GLASS
                val totalPrice = sell(pair)

                totalPrice shouldBe 9000
            }

            it("iron") {
                val pair = 10 to GarbageType.IRON
                val totalPrice = sell(pair)

                totalPrice shouldBe 1000
            }
        }
    }
})
