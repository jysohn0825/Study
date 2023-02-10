package algorithm.프로그래머스

class `오픈 채팅방` {
    fun solution(record: Array<String>): Array<Any> {
        val member = HashMap<String, String>()
        for (i in record.indices) {
            val message = record[i].split(" ")
            if (message.size == 3) {
                member[message[1]] = message[2]
            }
        }
        val answer = buildList {
            for (i in record.indices) {
                val str = record[i].split(" ")
                when (str[0]) {
                    "Enter" -> add("${member[str[1]]}님이 들어왔습니다.")
                    "Leave" -> add("${member[str[1]]}님이 나갔습니다.")
                }
            }
        }
        return answer.toTypedArray()
    }
}

fun main() {
    val data = `오픈 채팅방`().solution(
        arrayOf(
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        )
    )

    for (i in data.indices) {
        print(data[i])
    }
}
