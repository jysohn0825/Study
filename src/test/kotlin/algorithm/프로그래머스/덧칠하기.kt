package algorithm.프로그래머스

class `덧칠하기` {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer = 0
        var check = 0
        if (m == 1) return section.size
        section.forEach {
            if (it > check) {
                answer += 1
                check = it + m - 1
            }
        }
        return answer
    }
}

fun main() {
    val size = `덧칠하기`().solution(8, 4, intArrayOf(2, 3, 6))
    println(size)
}
