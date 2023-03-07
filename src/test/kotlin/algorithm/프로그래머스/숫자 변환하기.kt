package algorithm.프로그래머스

import java.util.*

class `숫자 변환하기` {

    private val answer = arrayListOf<Int>()
    private val queue = LinkedList<Pair<Int, Int>>()
    private val visited = hashMapOf<Int, Boolean>()

    fun solution(x: Int, y: Int, n: Int): Int {
        bfs(x, y, n)
        return if (answer.isEmpty()) -1 else answer.first()
    }

    private fun bfs(x: Int, y: Int, n: Int) {
        queue.add(Pair(x, 0))

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            if (node.first > y) continue
            if (node.first == y) {
                answer.add(node.second)
                break
            }

            if (visited[node.first + n] != true) {
                queue.add(Pair(node.first + n, node.second + 1))
                visited[node.first + n] = true
            }
            if (visited[node.first * 2] != true) {
                queue.add(Pair(node.first * 2, node.second + 1))
                visited[node.first * 2] = true
            }
            if (visited[node.first * 3] != true) {
                queue.add(Pair(node.first * 3, node.second + 1))
                visited[node.first * 3] = true
            }
        }
    }
}

fun main() {
    val size = `숫자 변환하기`().solution(10, 40, 5)
    println(size)
}
