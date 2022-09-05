import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StreamTest : DescribeSpec({

    describe("filter") {
        val numbers = listOf("one", "two", "three", "four")

        val longerThan3 = numbers.filter { it.length > 3 }
        println(longerThan3)

        longerThan3 shouldBe listOf("three", "four")

        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
        val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10 }
        println("filteredMap = $filteredMap")

        filteredMap shouldBe mapOf("key11" to 11)

        context("filterIndexed") {
            it("인덱스를 통해 처리하고 싶을 때 사용하면 인덱스와 값에 접근할 수 있다.") {
                val filteredIndex =
                    numbers.filterIndexed { index, string -> (index != 0) && (string.length < 5) }
                println("filteredIndex = $filteredIndex")
            }
        }

        context("filterNot") {
            it("지정된 조건과 일치하지 않는 항목만 포함하는 리스트 반환") {
                val filteredNot = numbers.filterNot { it.length <= 3 }
                println("filteredNot = $filteredNot")
            }
        }

        context("filterIsInstance<T>") {
            it("주어진 타입을 만족하는 원소 필터링. T 타입과 관련된 함수를 쓸 수 있다.") {
                val somethings = listOf(null, 1, "two", 3.0, "four")
                println("All string elements in upper case:")
                somethings.filterIsInstance<String>().forEach { println(it.uppercase()) }
            }
        }

        context("partition") {
            it("리스트를 특정 조건에 따라 분리. List 나 Set 에서 사용할 수 있으며 Map 에는 사용 불가.") {
                val (match, rest) = numbers.partition { it.length > 3 }
                println("match = ${match}, rest = $rest")
            }
        }

        context("any") {
            it("조건을 만족하는 원소가 1개 이상 존재하면 true") {
                val any = numbers.any { it.endsWith("e") }
                any shouldBe true
            }

            it("any 는 조건식 없이도 사용할 수 있다. 이경우에 any 는 원소가 있을 경우 true 를 반환한다.") {
                val any = numbers.any()
                any shouldBe true
            }
        }

        context("none") {
            it("조건을 만족하는 원소가 없으면 true") {
                val none = numbers.none { it.endsWith("a") }
                none shouldBe true
            }

            it("none 은 조건식 없이도 사용할 수 있다. 이 경우에 none 은 원소가 있을 경우 false 를 반환한다.") {
                val none = numbers.none()
                none shouldBe false
            }
        }

        context("all") {
            it("모든 원소가 조건을 만족하면 true") {
                val all = numbers.all { it.endsWith("e") }
                all shouldBe false
            }

            it("all 함수는 비어있는 Collection 에 어떤 조건이 오더라도 true 를 반환한다. 이것을 vacuous truth 라고 한다.") {
                val all = emptyList<Int>().all { it > 5 }
                all shouldBe true
            }
        }
    }

})
