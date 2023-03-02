package algorithm.프로그래머스

class `두 큐 합 같게 만들기` {

    private val queueTemp1 = ArrayDeque<Int>()
    private val queueTemp2 = ArrayDeque<Int>()
    private var queue1Sum = 0L
    private var queue2Sum = 0L

    fun solution(queue1: IntArray, queue2: IntArray): Int {
        queueTemp1.addAll(queue1.toList())
        queueTemp2.addAll(queue2.toList())
        queue1Sum = queue1.sum().toLong()
        queue2Sum = queue2.sum().toLong()
        val totalSum = queue1Sum + queue2Sum
        if (totalSum % 2 != 0L) return -1
        if (queue1Sum == queue2Sum) return 0

        offerAndPoll()
        var answer = 1
        if (queue1Sum == queue2Sum) return answer

        do {
            offerAndPoll()
            answer += 1
            if (totalSum / 2 == queue1Sum) return answer
        } while (validCheck(queue1, queueTemp1))
        return -1
    }

    private fun offerAndPoll() {
        if (queue1Sum < queue2Sum) {
            val temp = queueTemp2.removeFirst()
            queueTemp1.add(temp)
            queue1Sum += temp
            queue2Sum -= temp
        } else {
            val temp = queueTemp1.removeFirst()
            queueTemp2.add(temp)
            queue1Sum -= temp
            queue2Sum += temp
        }
    }

    private fun validCheck(array: IntArray, queue: ArrayDeque<Int>): Boolean {
        return if (array.size != queue.size) true
        else array.toList() == queue.toList()
    }
}

fun main() {
    val size = `두 큐 합 같게 만들기`().solution(intArrayOf(1, 4), intArrayOf(4, 8))
    println(size)
}
