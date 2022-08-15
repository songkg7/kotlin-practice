package functions

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class BookTest : DescribeSpec({

    describe("Book 생성 시 유효성 검증") {
        it("author 는 이름란이 비어있지 않은 작가만 허용한다.") {
            val person = Person("song", 27)
            val book = Book(person)

            book.author shouldBe person
        }

        it("비어있다면 IllegalStateException 을 던진다.") {
            shouldThrow<IllegalStateException> {
                Book(Person("", 27))
            }
        }
    }
})
