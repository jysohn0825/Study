package algorithm.프로그래머스

import java.util.*
import java.util.stream.IntStream

class `택배상자` {
    fun solution(order: IntArray): Int {
        var answer = 0
        val stack: Stack<Int> = Stack()
        val queue: Queue<Int> = LinkedList()
        val size = order.size

        for (i in 1..size) {
            queue.add(i)
        }

        var flag = true

        while (flag) {
            if (!queue.isEmpty() && queue.peek() == order[answer]) {
                answer += 1
                queue.poll()
            } else if (!stack.isEmpty() && stack.peek() == order[answer]) {
                answer += 1
                stack.pop()
            } else if ((queue.size == 1 || queue.isEmpty()) && (stack.isEmpty() || stack.peek() != order[answer])) {
                flag = false
            } else {
                stack.add(queue.poll())
            }
        }
        return answer
    }

}

fun main() {
    val answer = `택배상자`().solution(
        intArrayOf(5,4,3,2,1)
    )
    println(answer)
}

