package algorithm.프로그래머스

import java.util.*
import java.util.Collections.sort

data class Pos(var y: Int, var x: Int)

class `무인도 여행` {

    fun solution(maps: Array<String>): Array<Int> {
        visited = Array(maps.size) { BooleanArray(maps[0].length) }
        map = Array(maps.size) { CharArray(maps[0].length) }
        for (i in maps.indices) {
            for (j in 0 until maps[0].length) {
                map[i][j] = maps[i][j]
            }
        }
        for (i in maps.indices) {
            for (j in 0 until maps[0].length) {
                if (!visited[i][j] && maps[i][j] != 'X') {
                    bfs(Pos(i, j))
                }
            }
        }
        sort(answer)
        if (answer.size == 0) answer.add(-1)
        return answer.toTypedArray<Int>()
    }

    companion object {
        var dx = intArrayOf(0, 0, -1, 1)
        var dy = intArrayOf(-1, 1, 0, 0)
        var visited: Array<BooleanArray> = emptyArray()
        var map: Array<CharArray> = emptyArray()
        var answer = ArrayList<Int>()
        fun bfs(start: Pos) {
            val q: Queue<Pos> = LinkedList()
            q.add(start)
            visited[start.y][start.x] = true
            var sum = 0
            while (!q.isEmpty()) {
                val cur = q.poll()
                sum += map[cur.y][cur.x].code - '0'.code
                for (i in 0..3) {
                    val ny = cur.y + dy[i]
                    val nx = cur.x + dx[i]
                    if (ny >= 0 && ny < map.size && nx >= 0 && nx < map[0].size && map[ny][nx] != 'X' && !visited[ny][nx]) {
                        q.add(Pos(ny, nx))
                        visited[ny][nx] = true
                    }
                }
            }
            answer.add(sum)
        }
    }
}

fun main() {
    val size = `무인도 여행`().solution(arrayOf("X591X", "X1X5X", "X231X", "1XXX1"))
    println(size)
}
