package basic.inheritance

import org.junit.jupiter.api.Test

internal class InheritanceTest {

    @Test
    internal fun dog() {
        val dog: Dog = Yorkshire()
        dog.sayHello()
    }

    @Test
    internal fun tiger() {
        val tiger: Tiger = SiberianTiger()
        tiger.sayHello()
    }

    @Test
    internal fun lion() {
        val lion: Lion = Asiatic("Rufo")
        lion.sayHello()
    }
}