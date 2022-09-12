package boj3003

fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    val chess = listOf(1, 1, 2, 2, 2, 8)
    for (i in 0 until 6) {
        print("${chess[i] - input[i]} ")
    }
}
