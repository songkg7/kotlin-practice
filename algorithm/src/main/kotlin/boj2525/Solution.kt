package boj2525

import java.time.LocalTime

fun main() {
    val currentTime = readLine()!!.split(" ").map { it.toInt() }
    val operatingTime = readLine()!!.toLong()
    val localTime = LocalTime.of(currentTime[0], currentTime[1])
    val result = localTime.plusMinutes(operatingTime)
    println("${result.hour} ${result.minute}")
}
