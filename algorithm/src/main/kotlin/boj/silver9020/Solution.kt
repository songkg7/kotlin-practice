package boj.silver9020

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.absoluteValue

val primeNumber = primeNumbers()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    val list = mutableListOf<Int>()
    for (i in 1..t) {
        list += br.readLine().toInt()
    }
    list.forEach {
        val result = goldbachPartition(it)
        bw.write("${result.first} ${result.second}")
        bw.newLine()
    }
    bw.flush()
    bw.close()
}

fun goldbachPartition(n: Int): Pair<Int, Int> {
    // n 을 반으로 나눈 후, 각각의 숫자에서 가장 가까운 소수끼리 합을 구했을 때, n 과 일치하는 지 찾는다.
    // 4 ~ 10000 사이의 소수를 먼저 찾아놓고 실행

    // n 보다 작은 소수를 가져오고, 해당 소수 그룹에서 합이 n 과 같을 수 있는 모든 조합 생성
    // 조합에서 서로의 차이가 가장 작은 pair 를 선택
    val numbers: List<Int> = when (val position = primeNumber.indexOfFirst { it > n }) {
        -1 -> {
            primeNumber
        }
        else -> {
            primeNumbers().subList(0, position)
        }
    }

    val combination = combination(numbers, n)

    return lessDifference(combination)
}

fun primeNumbers(): List<Int> {
    val nums = (2..10000).toMutableList()
    for (i in 2..1000) {
        for (j in i * 2..10000 step i) {
            nums -= j
        }
    }
    return nums
}

fun combination(list: List<Int>, target: Int): Set<Pair<Int, Int>> {
    val result = mutableSetOf<Pair<Int, Int>>()
    for (i in list) {
        for (j in list) {
            if (i + j == target) {
                result += i to j
            }
        }
    }
    return result
}

fun lessDifference(candidates: Set<Pair<Int, Int>>): Pair<Int, Int> {
    var flag = 10000
    var result = 0 to 0
    for (i in candidates) {
        if (flag > (i.first - i.second).absoluteValue) {
            flag = (i.first - i.second).absoluteValue
            result = i
        }
    }
    return result
}
