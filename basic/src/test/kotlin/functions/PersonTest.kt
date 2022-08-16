package functions

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class PersonTest : DescribeSpec({

    describe("with and also") {
        it("기본값이 설정된 person") {
            val person = getPerson()

            with(person) {
                name shouldBe "song"
                age shouldBe 27
            }
        }

        it("also") {
            // also 는 코드 블록 내에 전달된 수신객체를 그대로 반환한다.
            val person = getPerson().also {
                println(it.name)
                println(it.age)
            }

            with(person) { name shouldBe "song" }
        }
    }

})
