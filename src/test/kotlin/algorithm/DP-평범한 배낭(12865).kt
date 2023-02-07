package algorithm

import kotlin.math.max

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()
    val (count, maxWeight) = reader.readLine().split(" ").map { it.toInt() }
    val products = buildList {
        repeat(count) {
            val (weight, value) = reader.readLine().split(" ").map { it.toInt() }
            add(Product(weight, value))
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
    writer.write("${dp[count - 1][maxWeight]}")
    writer.close()
    reader.close()
}

data class Product(val weight: Int, val value: Int)
