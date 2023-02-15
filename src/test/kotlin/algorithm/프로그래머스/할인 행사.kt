package algorithm.프로그래머스

class `할인 행사` {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        val size = want.size
        val sum = number.sum()
        val matchInfo = buildList {
            for (index in 0 until size) {
                add(want[index] to number[index])
            }
        }
        val count = discount.size
        var answer = 0
        for (index in 0 .. count - sum) {
            val temp = discount.sliceArray(index until index + sum).groupingBy { it }.eachCount().toList()
            if (matchInfo.containsAll(temp)) {
                answer += 1
            }
        }
        return answer
    }
}


fun main() {
    val size = `할인 행사`().solution(
        arrayOf("banana", "apple", "rice", "pork", "pot"),
        intArrayOf(3, 2, 2, 2, 1),
        arrayOf(
            "chicken",
            "apple",
            "apple",
            "banana",
            "rice",
            "apple",
            "pork",
            "banana",
            "pork",
            "rice",
            "pot",
            "banana",
            "apple",
            "banana"
        )
    )
    println(size)
}
