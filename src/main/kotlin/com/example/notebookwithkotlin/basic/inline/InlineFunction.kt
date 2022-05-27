package com.example.notebookwithkotlin.basic.inline

import kotlinx.coroutines.delay

suspend fun main() {
    // repeat function 은 inline function 이기 때문에 컴파일 에러가 나지 않는다.
    repeat(5) {
        getStringSlowly()
    }
    // 반면, printFiveTimes function 은 inline 이 아니였기 때문에 inline 으로 선언해줘야 한다.
    printFiveTimes {
        getStringSlowly()
    }
}

suspend fun getStringSlowly(): String {
    delay(1000)
    return "My String!"
}

inline fun printFiveTimes(generator: () -> String) {
    repeat(5) {
        println(generator())
    }
}