package algorithm.프로그래머스

class `마법의 엘리베이터` {

    fun solution(storey: Int): Int {
        var temp = storey
        var answer = 0
        while (temp > 0) {
            val extra = temp % 10
            temp /= 10
            answer += if (extra == 5) {
                if (temp % 10 >= 5) {
                    temp++
                    10 - extra
                } else {
                    extra
                }
            } else if (extra > 5) {
                temp++
                10 - extra
            } else {
                extra
            }
        }
        return answer
    }
}

fun main() {
    val answer = `마법의 엘리베이터`().solution(
        155
    )
    println(answer)
}
