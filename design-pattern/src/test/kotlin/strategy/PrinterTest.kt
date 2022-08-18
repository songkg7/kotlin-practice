package strategy

import io.kotest.core.spec.style.DescribeSpec

internal class PrinterTest : DescribeSpec({

    describe("printer") {
        val lowerPrinter = Printer(lowerCaseFormatter)
        val upperPrinter = Printer(upperCaseFormatter)

        it("lower") {
            lowerPrinter.printString("TEST")
        }

        it("upper") {
            upperPrinter.printString("test")
        }
    }
})
