package boj.silver24060

// 알고리즘 수업 - 병합 정렬 1
// https://www.acmicpc.net/problem/24060
var count = 0
fun mergeSort(list: MutableList<Int>, left: Int, right: Int) {
    if (left >= right) return

    val mid = (left + right) / 2 // 중간값
    // divide
    mergeSort(list, left, mid) // 앞부분 정렬
    mergeSort(list, mid + 1, right) // 뒷부분 정렬
    merge(list, left, mid, right)
}

fun merge(list: MutableList<Int>, left: Int, mid: Int, right: Int) {
    val sortedList = mutableListOf<Int>()
    var start = left
    var end = mid + 1

    while (start <= mid && end <= right) {
        if (list[start] <= list[end]) {
            sortedList += list[start]
            start++
        } else {
            sortedList += list[end]
            end++
        }
    }

    if (end > right) { // 왼쪽 배열 부분이 남은 경우
        for (i in start..mid) {
            sortedList += list[i]
        }
    }

    if (start > mid) { // 오른쪽 배열 부분이 남은 경우
        for (i in end..right) {
            sortedList += list[i]
        }
    }

    // 결과를 list 에 저장
    for (e in sortedList.indices) {
        list[left + e] = sortedList[e]
        count++
        println("$list <- ${sortedList[e]} : $e 번 index")
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val split = br.readLine().split(" ").map { it.toInt() }
    val size = split[0]
    val saveCount = split[1]

    val list = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    mergeSort(list, 0, size - 1)

    bw.write("$list")
    bw.newLine()

    bw.flush()

    br.close()
    bw.close()
}
