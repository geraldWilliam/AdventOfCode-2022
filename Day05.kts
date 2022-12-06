// Day05.kts

import java.io.File

// Shared

val input = File("Data/Day05.txt").readText()

val testInput = """
    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
"""


val positionInput = testInput
	.split("\n\n")
	.first()
	.split("\n")

val indices = positionInput
	.last()
	.split(" ")
	.filter { !it.isBlank() }
	.map { it.toInt() }
println("Indices: " + indices) 

val rows = positionInput
	.dropLast(1)
	.filter {
		it.count() > 0
	}
	.map {
		it.filter { !it.isBlank() }
	}

for (index in indices) {
	println(index)
	for (row in rows.reversed()) {

		println(row)
		println("First: " + row.first())
	}
}