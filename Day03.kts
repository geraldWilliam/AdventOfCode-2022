// Day03.kts

import java.io.File

// Shared

val input = File("Data/Day03.txt").readText()

val values = input.trim().split("\n")

val alphabet = "abcdefghijklmnopqrstuvwxyz".map { it }

val uppercaseAlphabet = alphabet.map { it.uppercase().single() }

fun score(input: Char): Int {
	if (alphabet.contains(input)) {
		return alphabet.indexOf(input) + 1
	}
	if (uppercaseAlphabet.contains(input)) {
		return uppercaseAlphabet.indexOf(input) + alphabet.count() + 1
	}
	throw Exception()
}

// Part One

val duplicates = values.map {
	val boundary = it.count() / 2
	val firstCompartment = it.slice(0..boundary - 1)
	val secondCompartment = it.slice(boundary..it.count() - 1)
	firstCompartment.first { secondCompartment.contains(it) }
}

val output1 = duplicates.map {
	score(it)
}
.sum()

println("Sum of Priorities: " + output1)

// Part Two

val commonElements = values.chunked(3).map {
	val first = it[0]
	val second = it[1]
	val third = it[2]
	first.first { second.contains(it) && third.contains(it) }
}

val output2 = commonElements.map {
	score(it)
}
.sum()

println("Sum of Badge Priorities: " + output2)