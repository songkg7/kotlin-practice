package facade

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class FacadeTest: DescribeSpec({
    describe("Facade pattern") {
        it("test") {
            val facade = Repository(LocalDataSource(), NetworkDataSource())
            val data = facade.fetch()
            data shouldBe listOf("Harry Potter", "Ronald Weasley", "Hermione Granger")
        }
    }
})
