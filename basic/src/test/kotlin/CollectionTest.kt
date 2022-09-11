import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.maps.shouldContainKey
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe

class CollectionTest : DescribeSpec({

    describe("list") {
        val list = listOf(1, 2, 3)
        it("should have size 3") {
            list.size shouldBe 3
        }
        it("should contain 1") {
            list shouldContain 1
        }
        it("should last index") {
            list.size - 1 shouldBe 2
            list.lastIndex shouldBe 2
        }
        it("should have 3 elements") {
            list shouldHaveSize 3
        }

        context("sublist") {
            val subList = list.subList(0, 2)
            it("should have size 2") {
                subList.size shouldBe 2
            }
            it("should contain 1") {
                subList shouldContain 1
            }
            it("should last index") {
                subList.size - 1 shouldBe 1
                subList.lastIndex shouldBe 1
            }
            it("should have 2 elements") {
                subList shouldHaveSize 2
            }
        }

        context("binary search") {
            it("should find 1") {
                list.binarySearch(1) shouldBe 0
            }
            it("should find 2") {
                list.binarySearch(2) shouldBe 1
            }
            it("should find 3") {
                list.binarySearch(3) shouldBe 2
            }
            it("should not find 4") {
                list.binarySearch(4) shouldBe -4
            }
        }

        context("indexOf") {
            it("should find 1") {
                list.indexOf(1) shouldBe 0
            }
            it("should find 2") {
                list.indexOf(2) shouldBe 1
            }
            it("should find 3") {
                list.indexOf(3) shouldBe 2
            }
            it("should not find 4") {
                list.indexOf(4) shouldBe -1
            }
        }

        context("lastIndexOf") {
            it("should find 1") {
                list.lastIndexOf(1) shouldBe 0
            }
            it("should find 2") {
                list.lastIndexOf(2) shouldBe 1
            }
            it("should find 3") {
                list.lastIndexOf(3) shouldBe 2
            }
            it("should not find 4") {
                list.lastIndexOf(4) shouldBe -1
            }
        }

        context("contains") {
            it("should contain 1") {
                list.contains(1) shouldBe true
            }
            it("should contain 2") {
                list.contains(2) shouldBe true
            }
            it("should contain 3") {
                list.contains(3) shouldBe true
            }
            it("should not contain 4") {
                list.contains(4) shouldBe false
            }
        }

        context("containsAll") {
            it("should contain 1") {
                list.containsAll(listOf(1)) shouldBe true
            }
            it("should contain 1 and 2") {
                list.containsAll(listOf(1, 2)) shouldBe true
            }
            it("should contain 1, 2 and 3") {
                list.containsAll(listOf(1, 2, 3)) shouldBe true
            }
            it("should not contain 1, 2 and 4") {
                list.containsAll(listOf(1, 2, 4)) shouldBe false
            }
        }

        context("indexOfFirst") {
            it("should find 1") {
                list.indexOfFirst { it == 1 } shouldBe 0
            }
            it("should find 2") {
                list.indexOfFirst { it == 2 } shouldBe 1
            }
            it("should find 3") {
                list.indexOfFirst { it == 3 } shouldBe 2
            }
            it("should not find 4") {
                list.indexOfFirst { it == 4 } shouldBe -1
            }
        }

        context("indexOfLast") {
            it("should find 1") {
                list.indexOfLast { it == 1 } shouldBe 0
            }
            it("should find 2") {
                list.indexOfLast { it == 2 } shouldBe 1
            }
            it("should find 3") {
                list.indexOfLast { it == 3 } shouldBe 2
            }
            it("should not find 4") {
                list.indexOfLast { it == 4 } shouldBe -1
            }
        }

        context("lastIndexOf") {
            it("should find 1") {
                list.lastIndexOf(1) shouldBe 0
            }
            it("should find 2") {
                list.lastIndexOf(2) shouldBe 1
            }
            it("should find 3") {
                list.lastIndexOf(3) shouldBe 2
            }
            it("should not find 4") {
                list.lastIndexOf(4) shouldBe -1
            }
        }

        context("listIterator") {
            it("should iterate") {
                val iterator = list.listIterator()
                iterator.hasNext() shouldBe true
                iterator.next() shouldBe 1
                iterator.hasNext() shouldBe true
                iterator.next() shouldBe 2
                iterator.hasNext() shouldBe true
                iterator.next() shouldBe 3
                iterator.hasNext() shouldBe false
            }
        }

        context("listIterator with index") {
            it("should iterate") {
                val iterator = list.listIterator(1)
                iterator.hasNext() shouldBe true
                iterator.next() shouldBe 2
                iterator.hasNext() shouldBe true
                iterator.next() shouldBe 3
                iterator.hasNext() shouldBe false
            }
        }
    }

    describe("set") {
        val set = setOf(1, 2, 3)
        it("should have size 3") {
            set.size shouldBe 3
        }
        it("should contain 1") {
            set shouldContain 1
        }
        it("should have 3 elements") {
            set shouldHaveSize 3
        }

        context("contains") {
            it("should contain 1") {
                set.contains(1) shouldBe true
            }
            it("should contain 2") {
                set.contains(2) shouldBe true
            }
            it("should contain 3") {
                set.contains(3) shouldBe true
            }
            it("should not contain 4") {
                set.contains(4) shouldBe false
            }
        }

        context("containsAll") {
            it("should contain 1") {
                set.containsAll(listOf(1)) shouldBe true
            }
            it("should contain 1 and 2") {
                set.containsAll(listOf(1, 2)) shouldBe true
            }
            it("should contain 1, 2 and 3") {
                set.containsAll(listOf(1, 2, 3)) shouldBe true
            }
            it("should not contain 1, 2 and 4") {
                set.containsAll(listOf(1, 2, 4)) shouldBe false
            }
        }

        context("iterator") {
            it("should iterate") {
                val iterator = set.iterator()
                iterator.hasNext() shouldBe true
                iterator.next() shouldBe 1
                iterator.hasNext() shouldBe true
                iterator.next() shouldBe 2
                iterator.hasNext() shouldBe true
                iterator.next() shouldBe 3
                iterator.hasNext() shouldBe false
            }
        }

        context("isEmpty") {
            it("should not be empty") {
                set.isEmpty() shouldBe false
            }
        }

        context("isNotEmpty") {
            it("should be not empty") {
                set.isNotEmpty() shouldBe true
            }
        }

        context("size") {
            it("should have size 3") {
                set.size shouldBe 3
            }
        }

        context("toTypedArray") {
            it("should have size 3") {
                set.toTypedArray().size shouldBe 3
            }
        }

        context("toMutableSet") {
            val mutableSet = set.toMutableSet()
            it("should have size 3") {
                mutableSet.size shouldBe 3
            }
            it("should mutate") {
                mutableSet.add(4)
                mutableSet.size shouldBe 4
            }
        }
    }

    describe("map") {
        val map = mapOf(1 to "one", 2 to "two", 3 to "three")
        it("should have size 3") {
            map.size shouldBe 3
        }
        it("should contain 1") {
            map shouldContainKey 1
        }
        it("should have 3 elements") {
            map shouldHaveSize 3
        }

        context("contains") {
            it("should contain 1") {
                map.contains(1) shouldBe true
            }
            it("should contain 2") {
                map.contains(2) shouldBe true
            }
            it("should contain 3") {
                map.contains(3) shouldBe true
            }
            it("should not contain 4") {
                map.contains(4) shouldBe false
            }
        }

        context("entries") {
            it("should iterate") {
                val iterator = map.entries.iterator()
                iterator.hasNext() shouldBe true
                iterator.next() shouldBe 1 to "one"
                iterator.hasNext() shouldBe true
                iterator.next() shouldBe 2 to "two"
                iterator.hasNext() shouldBe true
                iterator.next() shouldBe 3 to "three"
                iterator.hasNext() shouldBe false
            }
        }

        context("isEmpty") {
            it("should not be empty") {
                map.isEmpty() shouldBe false
            }
        }

        context("isNotEmpty") {
            it("should be not empty") {
                map.isNotEmpty() shouldBe true
            }
        }

        context("keys") {
            it("should iterate") {
                val iterator = map.keys.iterator()
                iterator.hasNext() shouldBe true
                iterator.next() shouldBe 1
                iterator.hasNext() shouldBe true
                iterator.next() shouldBe 2
                iterator.hasNext() shouldBe true
            }
        }
    }
})
