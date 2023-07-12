package algorithm.프로그래머스

class `연속된 부분 수열의 합` {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var left = 0
        var right = 0
        var sum = sequence[0]
        val size = sequence.size
        val answer = intArrayOf(0, Int.MAX_VALUE)
        while (left < size) {
            if (sum < k) {
                if (right == size - 1) break
                sum += sequence[++right]
            } else {
                if (sum == k) {
                    if (answer[1] - answer[0] > right - left) {
                        answer[0] = left
                        answer[1] = right
                    }
                }
                sum -= sequence[left++]
            }
        }
        return answer
    }
}

fun main() {
    val answer = `연속된 부분 수열의 합`().solution(intArrayOf(1, 2, 3, 4, 5), 7)
}
