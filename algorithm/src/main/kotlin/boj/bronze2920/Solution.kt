package boj.bronze2920

// 음계
// https://www.acmicpc.net/problem/2920
val ascend = listOf(1, 2, 3, 4, 5, 6, 7, 8)
val descend = ascend.reversed()
fun main() = when (readLine()!!.split(" ").map { it.toInt() }) {
    ascend -> {
        println("ascending")
    }

    descend -> {
        println("descending")
    }

    else -> {
        println("mixed")
    }
}
