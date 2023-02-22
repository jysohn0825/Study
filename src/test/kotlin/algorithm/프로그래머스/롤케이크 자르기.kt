package algorithm.프로그래머스

class `롤케이크 자르기` {

    fun solution(topping: IntArray): Int {
        var answer = 0
        val olderBrother = HashMap<Int, Int>()
        val youngerBrother = HashMap<Int, Int>()
        for (i in topping) {
            youngerBrother[i] = youngerBrother.getOrDefault(i, 0) + 1
        }

        for (i in topping.indices) {
            olderBrother[topping[i]] = olderBrother.getOrDefault(topping[i], 0) + 1
            youngerBrother[topping[i]] = youngerBrother.getOrDefault(topping[i], 0) - 1
            if (youngerBrother.getOrDefault(topping[i], 0) == 0) {
                youngerBrother.remove(topping[i])
            }
            if (olderBrother.size == youngerBrother.size) {
                answer++
            }
        }
        return answer
    }
}

fun main() {
    val size = `롤케이크 자르기`().solution(intArrayOf(1, 2, 1, 3, 1, 4, 1, 2))
    println(size)
}
