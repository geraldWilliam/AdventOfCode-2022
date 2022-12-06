// Day05.kts

import java.io.File

// Shared

val input = File("Data/Day05.txt").readText()

val positionInput = input
	.split("\n\n")
	.first()
	.split("\n")

val indices = positionInput
	.last()
	.split(" ")
	.filter { !it.isBlank() }
	.map { it.toInt() }

val rows = positionInput
	.dropLast(1)
	.filter {
		it.count() > 0
	}

var charIndices = arrayOf(1)
for (index in indices.dropLast(1)) {
	val next = charIndices.last() + 4
	charIndices += next
}

val stacks = indices.map {
	val index = it
	rows.reversed().map {
		if (it.isBlank()) {
			null
		} else {
			it[charIndices[index - 1]]
		}
	}
	.filter { it.toString() != " " }
	.filterNotNull()
	.toMutableList()
}

class Move(val from: Int, val to: Int, val length: Int) {}

val moves = input.split("\n\n")
	.last()
	.split("\n")
	.filter { !it.isBlank() }
	.map {
		it.split(" ")
			.map {
				try {
					it.toInt()
				} catch(e: Exception) {
					null
				}
			}
			.filterNotNull()
	}
	.map {
		Move(it[1], it[2], it[0])
	}

// Part One

var result1 = indices.map {
	val index = it
	rows.reversed().map {
		if (it.isBlank()) {
			null
		} else {
			it[charIndices[index - 1]]
		}
	}
	.filter { it.toString() != " " }
	.filterNotNull()
	.toMutableList()
}

for (move in moves) {
	val fromIndex = move.from - 1
	val toIndex = move.to - 1 
	for (i in 0..move.length - 1) {
		if (!result1[fromIndex].isEmpty()) {
			val box = result1[fromIndex].removeLast()
			result1[toIndex] += box	
		}
	}
}

val output1 = result1.map { it.last() }
println(output1.joinToString(""))

// Part Two

var result2 = indices.map {
	val index = it
	rows.reversed().map {
		if (it.isBlank()) {
			null
		} else {
			it[charIndices[index - 1]]
		}
	}
	.filter { it.toString() != " " }
	.filterNotNull()
	.toMutableList()
}

for (move in moves) {
	val fromIndex = move.from - 1
	val toIndex = move.to - 1
	if (!result2[fromIndex].isEmpty()) {
		val boxes = (0..move.length - 1).map { 
			result2[fromIndex].removeLast()
		}
		.reversed()
		result2[toIndex] += boxes
	}
}

val output2 = result2.map { it.last() }
println(output2.joinToString(""))

