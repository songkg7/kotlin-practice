package boj.bronze25305

fun main() {
    val split = readLine()!!.split(" ").map { it.toInt() }
    val k = split[1]

    val elements = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()

    println(elements[k - 1])
}
