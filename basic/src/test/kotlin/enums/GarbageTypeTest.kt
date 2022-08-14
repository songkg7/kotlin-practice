package enums

import io.kotest.core.spec.style.DescribeSpec

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


        }
    }
})
