// DayOne.kts

import java.io.File

val input = File("Data/DayOne.txt").readText()

// Shared

val values = input.split("\n\n")
    .map {
        it.trim()
        it.split("\n")
            .map {
                it.trim()
                it.toInt()
            }
            .sum()
    }

// Part One

val output1 = values.max()
println("Max Value: " + output1)

// Part Two

val sorted = values.sorted().reversed()
val topThree = sorted.slice(0..2)
val output2 = topThree.sum()
println("Top Three Total: " + output2)

