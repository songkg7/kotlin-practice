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

            it("java class type 을 호출해서 사용할 수 있다.") {
                val somethings = listOf(1, 2, 3, "4")
                val filterIsInstance = somethings.filterIsInstance(String::class.java)
                filterIsInstance shouldBe listOf("4")
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

            it("조건식 없이도 사용할 수 있다. 이경우에 원소가 있을 경우 true 를 반환한다.") {
                val any = numbers.any()
                any shouldBe true
            }
        }

        context("none") {
            it("조건을 만족하는 원소가 없으면 true") {
                val none = numbers.none { it.endsWith("a") }
                none shouldBe true
            }

            it("조건식 없이도 사용할 수 있다. 이 경우에 원소가 있을 경우 false 를 반환한다.") {
                val none = numbers.none()
                none shouldBe false
            }
        }

        context("all") {
            it("모든 원소가 조건을 만족하면 true") {
                val all = numbers.all { it.endsWith("e") }
                all shouldBe false
            }

            it("비어있는 Collection 에 어떤 조건이 오더라도 true 를 반환한다. 이것을 vacuous truth 라고 한다.") {
                val all = emptyList<Int>().all { it > 5 }
                all shouldBe true
            }
        }
    }

    describe("map") {
        val numbers = setOf(1, 2, 3)

        context("mapIndexed") {
            it("인덱스와 값 둘 다 이용하여 조건을 주거나 새로운 값을 만들어 낼 수 있다.") {
                val map = numbers.map { it * 3 }
                map shouldBe setOf(3, 6, 9)
            }
        }

        context("mapNotNull") {
            it("null 인 원소들은 포함하지 않는다.") {
                val mapNotNull = numbers.mapNotNull { if (it == 2) null else it * 3 }
                mapNotNull shouldBe setOf(3, 9)
            }
        }

        context("mapIndexedNotNull") {
            it("null 인 원소들은 포함하지 않는다.") {
                val mapIndexedNotNull =
                    numbers.mapIndexedNotNull { index, value -> if (index == 0) null else value * index }
                mapIndexedNotNull shouldBe setOf(2, 6)
            }
        }

        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
        context("mapKeys") {
            it("Map 의 key 값들을 value 를 유지한채로 변경한다.") {
                val mapKeys = numbersMap.mapKeys { it.key.uppercase() }
                mapKeys shouldBe mapOf("KEY1" to 1, "KEY2" to 2, "KEY3" to 3, "KEY11" to 11)
            }
        }

        context("mapValues") {
            it("Map 의 key 값들을 유지한채로 value 를 변경한다.") {
                val mapValues = numbersMap.mapValues { it.value + it.key.length }
                mapValues shouldBe mapOf("key1" to 5, "key2" to 6, "key3" to 7, "key11" to 16)
            }
        }

        context("filterKeys") {
            it("조건에 따라 map 을 filtering 한다.") {
                val filterKeys = numbersMap.filterKeys { it == "key1" }
                filterKeys shouldBe mapOf("key1" to 1)
            }
        }

        context("plus") {
            it("주어진 pair 가 포함된 새로운 map 을 반환한다.") {
                val plus = numbersMap.plus("key5" to 5)
                plus shouldBe mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11, "key5" to 5)
            }

            it("operator function 이므로 + 를 사용해서 호출할 수 있다.") {
                val plus = numbersMap + ("key5" to 5)
                plus shouldBe mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11, "key5" to 5)
            }
        }

    }

    describe("mutableMap") {
        val numbersMap = mutableMapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)

    }
})
