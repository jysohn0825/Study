package algorithm.백준

import java.io.BufferedReader
import java.lang.StringBuilder
import java.util.*

fun main() {
    val reader: BufferedReader = System.`in`.bufferedReader()
    val count: Int = reader.readLine().toInt()
    val minHeap: PriorityQueue<Int> = PriorityQueue()
    val maxHeap: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
    val answer = StringBuilder()

    for (i in 0 until count) {
        val number: Int = reader.readLine().toInt()
        if (minHeap.size == maxHeap.size) {
            maxHeap += number
        } else {
            minHeap += number
        }
        if ((minHeap.isNotEmpty() && maxHeap.isNotEmpty()) && (minHeap.peek() < maxHeap.peek())) {
            val temp = minHeap.poll()
            minHeap += maxHeap.poll()
            maxHeap += temp
        }
        answer.append("${maxHeap.peek()}\n")
    }
    print(answer)
    reader.close()
}
