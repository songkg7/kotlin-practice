package boj.silver9020

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

const val mxN = 10_000
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val nP = BooleanArray(mxN + 1)
    nP[1] = true

    for (i in 2..mxN / 2) {
        if (nP[i]) {
            continue
        }
        var j = i * 2
        while (j <= mxN) {
            nP[j] = true
            j += i
        }
    }

    val t = br.readLine().toInt()
    for (i in 1..t) {
        val n = br.readLine().toInt()
        val half = n / 2

        for (j in half downTo 2) {
            if (!(nP[j]) && !(nP[n - j])) {
                bw.write("$j ${n - j}")
                bw.newLine()
                break
            }
        }
    }
    bw.flush()
    br.close()
}
