package algorithm.프로그래머스

import kotlin.math.absoluteValue

class `전력망을 둘로 나누기` {

    private var answer: Int = 100

    fun solution(n: Int, wires: Array<IntArray>): Int {
        val tree = Array(n + 1) { mutableListOf<Int>() }

        wires.forEach {
            val v1 = it[0]
            val v2 = it[1]
            tree[v1].add(v2)
            tree[v2].add(v1)
        }

        wires.forEach {
            val network1 = towerCount(it[0], it[1], tree, BooleanArray(n + 1))
            val network2 = towerCount(it[1], it[0], tree, BooleanArray(n + 1))

            answer = answer.coerceAtMost((network1 - network2).absoluteValue)
        }

        return answer
    }

    private fun towerCount(v1: Int, v2: Int, tree: Array<MutableList<Int>>, visited: BooleanArray): Int {
        var count = 1
        val queue = ArrayDeque<Int>()
        visited[v1] = true
        queue.add(v1)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()

            tree[current].forEach { next ->
                if (!visited[next] && next != v2) {
                    count++
                    visited[next] = true
                    queue.add(next)
                }
            }
        }
        return count
    }
}

fun main() {
    val size = `전력망을 둘로 나누기`().solution(1, arrayOf(intArrayOf(1, 2)))
    println(size)
}
