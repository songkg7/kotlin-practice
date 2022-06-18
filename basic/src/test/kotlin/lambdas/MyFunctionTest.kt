package lambdas

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MyFunctionTest {

    @Test
    internal fun invoke() {
        val message = MyFunction.invoke("hello")
        println(message)

        val message2 = MyFunction("world")
        println(message2)

        message shouldBe "HELLO"
        message2 shouldBe "WORLD"
    }
}