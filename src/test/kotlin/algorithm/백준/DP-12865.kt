package algorithm.백준

import kotlin.math.max

data class Product(val weight: Int, val value: Int)

fun main() {
    val reader = System.`in`.bufferedReader()
    val (count, maxWeight) = reader.readLine().split(" ").map { it.toInt() }
    val products = buildList {
        repeat(count) {
            val (weight, value) = reader.readLine().split(" ").map { it.toInt() }
            this += Product(weight, value)
        }
    }

    val dp = Array(count) { Array(maxWeight + 1) { 0 } }
    for (weight in 0..maxWeight) {
        if (products[0].weight <= weight) {
            dp[0][weight] = products[0].value
        }
    }
    for (index in 1 until count) {
        for (weight in 0..maxWeight) {
            dp[index][weight] =
                if (products[index].weight <= weight)
                    max(dp[index - 1][weight], dp[index - 1][weight - products[index].weight] + products[index].value)
                else
                    dp[index - 1][weight]

        }
    }
    println(dp[count - 1][maxWeight])
    reader.close()
}
