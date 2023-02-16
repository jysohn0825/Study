package algorithm.프로그래머스

class `2개 이하로 다른 비트` {

    fun solution(numbers: LongArray): LongArray {
        return buildList {
            for (i in numbers.indices) {
                val number = numbers[i] + 1
                add(number + (number.xor(numbers[i])).shr(2))
            }
        }.toLongArray()
    }
}

fun main() {
    val answer = `2개 이하로 다른 비트`().solution(longArrayOf(2, 7))
    answer.forEach {
        println(it)
    }
}
