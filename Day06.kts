// Day06.kts

import java.io.File

// Shared

val input = File("Data/Day06.txt").readText()

fun markerIndex(start: Int, length: Int): Int? {
	val index = start
	val endIndex = minOf(index + (length - 1), input.lastIndex)
	val elements = input.slice(index..endIndex)
	if (elements.count() == elements.toSet().count()) {
		return endIndex + 1
	} else {
		return null
	}
}

// Part One

val output1 = input.indices.map {
	markerIndex(it, 4)
}
.filterNotNull()
.first()

println("Index of packet marker: " + output1)

// Part Two

val output2 = input.indices.map {
	markerIndex(it, 14)
}
.filterNotNull()
.first()

println("Index of message marker: " + output2)