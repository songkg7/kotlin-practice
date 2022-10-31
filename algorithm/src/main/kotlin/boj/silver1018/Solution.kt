package boj.silver1018

import java.util.*

// 체스판 다시 칠하기
// https://www.acmicpc.net/problem/1018
fun main() {
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine())

    val row = st.nextToken().toInt()
    val column = st.nextToken().toInt()

    var min = row * column

    // 다시 칠할 칸 개수를 저장할 배열
    val arr = Array(row) { IntArray(column) }

    // 시작점(0, 0)을 흰색(W)으로 가정
    // row + column = 짝수 -> W
    // row + column = 홀수 -> B
    for (i in 0 until row) {
        val line = br.readLine().toCharArray()

        // 각 row 마다 첫번째 칸부터 j 번째 칸까지
        // 몇개의 칸을 다시 칠해야 하는지 계산해서 저장
        for (j in 0 until column) {
            // 다시 칠해야 하는 경우
            if (((i + j) % 2 == 0 && line[j] != 'W') || ((i + j) % 2 != 0 && line[j] != 'B')) {
                arr[i][j]++
            }

            // 왼쪽 칸에 저장되어 있던 다시 칠할 개수 더하기 (누적)
            if (j > 0) arr[i][j] += arr[i][j - 1]
        }
    }

    // 체스판의 시작점을 (i, j) 로 잡고 8*8 체스판으로 자르면서 최소값 찾기
    for (i in 0..row - 8) {
        for (j in 0..column - 8) {
            var count = 0

            // 체스판 안에 다시 칠해야 하는 개수 계산
            for (k in i until i + 8) {
                // 0칸부터 j+7칸 사이의 다시 칠해야 하는 칸 수
                count += arr[k][j + 7]

                // j칸 이전에 존재하는 다시 칠해야 하는 칸 수는 제외
                if (j > 0) count -= arr[k][j - 1]
            }

            // 첫 칸을 흰색으로 가정했을 경우 칠해야 할 개수가 과반수를 넘는 경우
            // 첫 칸을 검은색으로 가정하여 64에서 뺀 값을 칠해야할 개수로 설정
            if (count > 64 - count) count = 64 - count

            // 최소값인 경우 min 값 업데이트
            if (count < min) min = count
        }
    }

    println(min)
    br.close()
}
