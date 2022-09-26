package boj.bronze25501

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var n = 0
fun recursion(s: String, l: Int, r: Int): Int {
    n += 1
    return when {
        l >= r -> {
            1
        }

        s[l] != s[r] -> {
            0
        }

        else -> {
            recursion(s, l + 1, r - 1)
        }
    }
}

fun isPalindrome(s: String): Int {
    n = 0
    return recursion(s, 0, s.lastIndex)
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(br.readLine().toInt()) {
        val palindrome = isPalindrome(br.readLine())

        bw.write("$palindrome $n")
        bw.newLine()
    }
    bw.flush()
    br.close()
}
