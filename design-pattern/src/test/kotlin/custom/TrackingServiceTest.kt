package custom

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class TrackingServiceTest: DescribeSpec({

    describe("tracking") {
        it("should return tracking") {
            val trackingService = TrackingService(ListConverter())

            trackingService.tracking() shouldBe "tracking"
        }
    }

    describe("convertedTracking") {
        it("should return converted tracking") {
            val trackingService = TrackingService(ListConverter())

            trackingService.convertedTracking() shouldBe listOf("t", "r", "a", "c", "k", "i", "n", "g")
        }
    }

})
