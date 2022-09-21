package boj.silver1065

// 한수
fun main() {
    val n = readLine()!!.toInt()
    val result = mutableListOf<Int>()
    for (i in 1..n) {
        if (isArithmetic(i)) result += i
    }
    println(result.size)
}

fun isArithmetic(n: Int): Boolean {
    val string = n.toString()
    if (string.length == 1) {
        return true
    }
    if (string.length == 2) {
        return true
    }
    if (string.length == 3) {
        val a = string[0].digitToInt() - string[1].digitToInt()
        val b = string[1].digitToInt() - string[2].digitToInt()
        return a == b
    }
    return false
}
