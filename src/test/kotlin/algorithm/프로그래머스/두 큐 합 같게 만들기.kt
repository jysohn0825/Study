package algorithm.프로그래머스

import java.util.*

class `두 큐 합 같게 만들기` {

    private val queueTemp1 = LinkedList<Int>()
    private val queueTemp2 = LinkedList<Int>()
    private var queue1Sum = 0L
    private var queue2Sum = 0L

    fun solution(queue1: IntArray, queue2: IntArray): Int {
        queueTemp1.addAll(queue1.toList())
        queueTemp2.addAll(queue2.toList())
        queue1Sum = queue1.sum().toLong()
        queue2Sum = queue2.sum().toLong()
        val totalSum = queue1Sum + queue2Sum
        if (totalSum % 2 != 0L) return -1

        offerAndPoll()
        var answer = 1

        do {
            offerAndPoll()
            answer += 1
            if (totalSum / 2 == queue1Sum) return answer
        } while (validCheck(queue1, queueTemp1))
        return -1
    }

    private fun offerAndPoll() {
        if (queue1Sum < queue2Sum) {
            val temp = queueTemp2.poll()
            if (temp != null) queueTemp1.offer(temp)
            queue1Sum += (temp ?: 0)
            queue2Sum -= (temp ?: 0)
        } else {
            val temp = queueTemp1.poll()
            if (temp != null) queueTemp2.offer(temp)
            queue1Sum -= (temp ?: 0)
            queue2Sum += (temp ?: 0)
        }
    }

    private fun validCheck(array: IntArray, queue: LinkedList<Int>): Boolean {
        if (array.size != queue.size) return true
        else {
            for (i in array.indices) {
                if (array[i] != queue[i]) return true
            }
            return false
        }
    }
}

fun main() {
    val size = `두 큐 합 같게 만들기`().solution(intArrayOf(1, 4), intArrayOf(4, 8))
    println(size)
}
