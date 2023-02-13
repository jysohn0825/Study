package algorithm.프로그래머스

import kotlin.math.sqrt

class `k진수에서 소수 개수 구하기` {

    fun solution(n: Int, k: Int): Int {
        var answer = 0
        var number = 0L
        val binaryString = changeBinary(n, k)
        for (binaryCharacter in binaryString) {
            if (binaryCharacter == '0') {
                answer += checkPrime(number)
                number = 0
            } else {
                number = number * 10 + Character.getNumericValue(binaryCharacter)
            }
        }
        answer += checkPrime(number)
        return answer
    }

    private fun changeBinary(n: Int, k: Int): String {
        val sb = StringBuilder()
        var num = n
        while (num != 0) {
            sb.insert(0, num % k)
            num /= k
        }
        return sb.toString()
    }

    private fun checkPrime(num: Long): Int {
        if (num <= 1) return 0
        val sqrt = sqrt(num.toDouble()).toLong()
        for (index in 2..sqrt) {
            if (num % index == 0L) return 0
        }
        return 1
    }
}

fun main() {
    val size = `k진수에서 소수 개수 구하기`().solution(437674, 3)
    println(size)
}
