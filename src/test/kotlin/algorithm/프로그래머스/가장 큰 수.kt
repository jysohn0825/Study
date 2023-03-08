package algorithm.프로그래머스

class `가장 큰 수` {
    fun solution(numbers: IntArray): String {
        val array = numbers.map { it.toString() }
            .sortedWith { o1, o2 -> (o2 + o1).compareTo((o1 + o2)) }
        return if (array[0] == "0") "0" else array.joinToString("")
    }
}

fun main() {
    val size = `가장 큰 수`().solution(intArrayOf(6, 2, 10))
    println(size)
}
