package algorithm.프로그래머스

import java.time.Duration
import java.time.LocalTime


data class RecordType(val inTime: LocalTime, var endTime: LocalTime = LocalTime.MAX, var money: Int = 0) {
    val elapsedTime: Int
        get() = Duration.between(inTime, endTime).toMinutes().toInt()
}

data class FeeType(val basicMinute: Int, val basicMoney: Int, val unitMinute: Int, val unitMoney: Int) {
    constructor(fees: IntArray) : this(fees[0], fees[1], fees[2], fees[3])
}

class `주차 요금 계산` {

    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val feeType = FeeType(fees)
        val recordTime = mutableMapOf<String, RecordType>()
        records.forEach {
            val record = it.split(" ")
            val time = record[0].split(":").map { stringTime -> stringTime.toInt() }
            if (record[2] == "IN") {
                // TODO 동일한 차 번호일 경우 다시 체크할 수 있도록 수정 필요
                recordTime[record[1]] = RecordType(LocalTime.of(time[0], time[1]))
            } else {
                recordTime[record[1]]!!.endTime = LocalTime.of(time[0], time[1])
            }
        }
        recordTime.forEach { (carNumber, recordType) ->
            recordTime[carNumber]!!.money =
                if (recordType.elapsedTime <= feeType.basicMinute) {
                    feeType.basicMoney
                } else {
                    feeType.basicMoney + (recordType.elapsedTime - feeType.basicMinute) / feeType.unitMinute * feeType.unitMoney
                }
        }
        return recordTime.toSortedMap().map { it.value.money }.toIntArray()
    }
}

fun main() {
    val size = `주차 요금 계산`().solution(
        intArrayOf(180, 5000, 10, 600),
        arrayOf(
            "05:34 5961 IN",
            "06:00 0000 IN",
            "06:34 0000 OUT",
            "07:59 5961 OUT",
            "07:59 0148 IN",
            "18:59 0000 IN",
            "19:09 0148 OUT",
            "22:59 5961 IN",
            "23:00 5961 OUT"
        )
    )
    size.forEach {
        println(it)
    }
}
