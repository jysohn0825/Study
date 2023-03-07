package algorithm.프로그래머스

class `피로도` {
    var answer = 0

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        dfs(k, dungeons, 0, BooleanArray(dungeons.size))
        return answer
    }

    private fun dfs(cur: Int, dungeons: Array<IntArray>, cnt: Int, visited: BooleanArray) {
        if (cnt == dungeons.size) {
            answer = answer.coerceAtLeast(cnt)
            return
        }
        for (i in dungeons.indices) {
            if (visited[i]) continue
            if (cur < dungeons[i][0]) {
                answer = answer.coerceAtLeast(cnt)
                continue
            }
            visited[i] = true
            dfs(cur - dungeons[i][1], dungeons, cnt + 1, visited)
            visited[i] = false
        }
    }
}

fun main() {
    val size = `피로도`().solution(80, arrayOf(intArrayOf(80, 20), intArrayOf(50, 40), intArrayOf(30, 10)))
    println(size)
}
