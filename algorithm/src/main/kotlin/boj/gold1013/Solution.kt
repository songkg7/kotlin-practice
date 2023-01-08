package boj.gold1013

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.regex.Pattern

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val regex = "(100+1+|01)+"

    val count = br.readLine().toInt()
    val target: MutableList<String> = mutableListOf()
    for (i in 1..count) {
        target.add(br.readLine())
    }

    val result: MutableList<String> = mutableListOf()
    val pattern = Pattern.compile(regex)
    for (i in target) {
        val matches = pattern.matcher(i).matches()
        when {
            matches -> result.add("YES")
            else -> result.add("NO")
        }
    }

    for (i in result) {
        println(i)
    }

    br.close()
}
