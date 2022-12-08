package reactor

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.CompletableFuture

class ReactorTest : DescribeSpec({

    describe("Mono") {
        it("just") {
            val mono = Mono.just("Hello")
            mono.subscribe { println(it) }
        }

        it("empty") {
            val mono = Mono.empty<String>()
            mono.subscribe { println(it) }
        }

        it("error") {
            val mono = Mono.error<String>(IllegalStateException("error"))
            mono.subscribe({ println(it) }, { println(it) })
        }

        it("defer") {
            val mono = Mono.defer { Mono.just("Hello") }
            mono.subscribe { println(it) }
        }

        it("fromCallable") {
            val mono = Mono.fromCallable { "Hello" }
            mono.subscribe { println(it) }
        }

        it("fromSupplier") {
            val mono = Mono.fromSupplier { "Hello" }
            mono.subscribe { println(it) }
        }

        it("fromFuture") {
            val mono = Mono.fromFuture { CompletableFuture.completedFuture("Hello") }
            mono.subscribe { println(it) }
        }

        it("fromCompletionStage") {
            val mono = Mono.fromCompletionStage { CompletableFuture.completedFuture("Hello") }
            mono.subscribe { println(it) }
        }
    }

    describe("Flux") {
        context("subscribe") {
            val flux = Flux.just("Hello", "World")
            it("basic") {
                flux.subscribe { println(it) }
            }
            it("onNext") {
                flux.subscribe({ println(it) }, { println(it) }, { println("complete") })
            }
            it("return data") {
                val result = mutableListOf<String>()
                flux.subscribe({ result.add(it) }, { println(it) }, { println("complete1") })
                flux.subscribe({ result.add(it) }, { println(it) }, { println("complete2") })

                println("result = $result")

                result.size shouldBe 4
                result shouldBe listOf("Hello", "World", "Hello", "World")
            }
        }

        it("just") {
            val flux = Flux.just("Hello", "World")
                .doOnSubscribe { println("-- doOnSubscribe --") }
                .doOnNext { println("doOnNext: $it") }
                .doOnComplete { println("-- doOnComplete --") }
            flux.subscribe { println(it) }
            flux.subscribe { println(it) }
        }

        context("window") {
            it("일정 개수로 묶기") {
                val flux = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                    .window(3)
                flux.subscribe { it.collectList().subscribe { list -> println(list) } }
            }

            it("skip: size 보다 skip count 가 작으므로 일부 데이터의 중복이 발생한다.") {
                val flux = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                    .window(3, 2)
                flux.subscribe { it.collectList().subscribe { list -> println(list) } }
            }

            it("skip: size 보다 skip count 가 크므로 일부 데이터의 유실이 발생한다.") {
                val flux = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                    .window(3, 4)
                flux.subscribe { it.collectList().subscribe { list -> println(list) } }
            }
        }
    }
})
