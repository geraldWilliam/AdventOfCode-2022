// Day01.kts

import java.io.File

// Shared

val input = File("Data/Day01.txt").readText()

val values = input.trim().split("\n\n").map {
    it.split("\n").map { it.toInt() }.sum()
}

// Part One

val output1 = values.max()
println("Max Value: " + output1)

// Part Two

val output2 = values.sorted().reversed().slice(0..2).sum()
println("Top Three Total: " + output2)
