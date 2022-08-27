package sealedclasses

import io.kotest.core.spec.style.DescribeSpec

internal class ColorTest: DescribeSpec({

    describe("sealed class test") {
        it("basic") {
            val red = Color.Red(0, 0, 0)
            val yellow = Color.Yellow(0, 0, 0)

        }
    }
})
