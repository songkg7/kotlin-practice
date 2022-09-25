package boj.bronze1712

fun main() {
    val split = readLine()!!.split(" ").map { it.toInt() }
    val a = split[0]
    val b = split[1]
    val c = split[2]

    if (c <= b) {
        return println(-1)
    }

    val d = c - b
    println(a / d + 1)
}
