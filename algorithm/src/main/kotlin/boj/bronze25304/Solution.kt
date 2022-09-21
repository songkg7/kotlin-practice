package boj.bronze25304

// 영수증
fun main() {
    val totalPrice = readLine()!!.toInt()
    val categories = readLine()!!.toInt()
    var result = 0
    repeat(categories) {
        val split = readLine()!!.split(" ").map { it.toInt() }
        result += split[0] * split[1]
    }

    println(if (result == totalPrice) "Yes" else "No")
}
