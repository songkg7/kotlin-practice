import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime

private fun ZonedDateTime.compareWithSameInstant(other: ZonedDateTime): Boolean {
    return this.withZoneSameInstant(ZoneOffset.UTC) == other.withZoneSameInstant(ZoneOffset.UTC)
}

class TimeTest : DescribeSpec({

    describe("ZonedDateTime") {
        val utc = ZonedDateTime.of(
            2020, 1, 1, 0, 0, 0, 0,
            ZoneId.of("UTC")
        )

        val seoul = ZonedDateTime.of(
            2020, 1, 1, 9, 0, 0, 0,
            ZoneId.of("Asia/Seoul")
        )

        it("ZonedDateTime 의 property 가 다르다면 절대적인 시간이 같더라도 다른 객체다.") {
            utc shouldNotBe seoul
        }

        it("extension method 를 정의해서 검증할 수 있다.") {
            utc.compareWithSameInstant(seoul) shouldBe true
        }

    }
})

