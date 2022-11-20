package jctools

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.jctools.maps.NonBlockingHashMap

class JcToolsTest: DescribeSpec({

    describe("NonBlockingHashMap") {
        val map = NonBlockingHashMap<String, String>()

        it("should work") {
            map["foo"] = "bar"
            map["foo"] shouldBe "bar"
        }
    }

})
