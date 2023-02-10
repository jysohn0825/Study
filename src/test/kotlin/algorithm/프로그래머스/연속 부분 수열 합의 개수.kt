package algorithm.프로그래머스

class `연속 부분 수열 합의 개수` {
    fun solution(elements: IntArray): Int {
        val answer = mutableSetOf<Int>()
        val size = elements.size
        val list = elements + elements
        for (s in 1..size) {
            for (i in 0..size) {
                answer.add(list.slice(i until i + s).sum())
            }
        }
        return answer.size
    }
}

fun main() {
    val size = `연속 부분 수열 합의 개수`().solution(intArrayOf(7, 9, 1, 1, 4))
    println(size)
}
