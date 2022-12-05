// Day04.kts

import java.io.File

// Shared

val input = File("Data/Day04.txt").readText()

val values = input.trim().split("\n").map {
	it.split(",").map {
		it.split("-").map {
			it.toInt()
		}
	}
}

val ranges = values.map {
	it.map {
		it[0]..it[1]
	}
} 

// Part One

val enclosedRanges = ranges.map {
	val left = it[0]
	val right = it[1]
	if (left.start <= right.start && left.endInclusive >= right.endInclusive) {
		right
	} else if (right.start <= left.start && right.endInclusive >= left.endInclusive) {
		left
	} else {
		null
	}
}

val output1 = enclosedRanges.filterNotNull().count()

println("Number of enclosed ranges: " + output1)

// Part Two

val overlappingRanges = ranges.map {
	val left = it[0]
	val right = it[1]
	left.intersect(right).count() > 0
}

val output2 = overlappingRanges.filter { it == true } .count()

println("Number of overlapping ranges: " + output2)