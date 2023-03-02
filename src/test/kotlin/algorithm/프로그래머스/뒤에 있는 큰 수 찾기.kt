package algorithm.프로그래머스

import java.util.*

class `뒤에 있는 큰 수 찾기` {
    fun solution(numbers: IntArray): IntArray {
        val stack: Stack<Int> = Stack()
        val size = numbers.size
        val answer = Array(numbers.size) { -1 }.toIntArray()
        for (i in 0 until size) {
            if (stack.isEmpty() || numbers[i] < numbers[i - 1]) {
                stack.push(i)
            } else {
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    answer[stack.pop()] = numbers[i]
                }
                stack.push(i)
            }
        }
        return answer
    }
}

fun main() {
    val size = `뒤에 있는 큰 수 찾기`().solution(intArrayOf(2, 3, 3, 5))
    println(size)
    size.forEach {
        println(it)
    }
}
