package observer.v1

import io.kotest.core.spec.style.DescribeSpec

class BaediTest : DescribeSpec({

    val baedi = Baedi()
    val lewin = Lewin()
    val tiber = Tiber()
    val jay = Jay()

    describe("if subscribe crews") {
        baedi.subscribe(lewin)
        baedi.subscribe(tiber)
        baedi.subscribe(jay)

        it("should notify crews") {
            baedi.upgradeCutie()
        }

        context("unsubscribe lewin") {
            baedi.unsubscribe(lewin)

            it("should notify crews except lewin") {
                baedi.eatFood()
            }
        }
    }
})
