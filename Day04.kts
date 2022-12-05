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

val enclosedRanges = values.map {
	val left = it.first()
	val right = it.last()
	if (left[0] >= right[0] && left[1] <= right[1]) {
		left
	} else if (right[0] >= left[0] && right[1] <= left[1]) {
		right
	} else {
		null
	}
}

val output1 = enclosedRanges.filterNotNull().count()

println("Number of enclosed ranges: " + output1)

val overlappingRanges = values.map {
	// val left = it.first()
	// val right = it.last()
	val ranges = it.map {
		it[0]..it[1]
	}
	ranges.first().intersects(ranges.last())
}

println(overlappingRanges.count())