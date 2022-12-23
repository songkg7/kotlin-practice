package composite

import io.kotest.core.spec.style.DescribeSpec

class ExodiaTest : DescribeSpec({

    describe("Exodia summoning") {
        context("when all parts are added") {
            it("should summon Exodia the Forbidden One") {
                val exodia = Exodia()
                exodia.add(Head)
                exodia.add(RightArm)
                exodia.add(LeftArm)
                exodia.add(RightLeg)
                exodia.add(LeftLeg)
            }
        }
    }

})
