// DayTwo.kts

import java.io.File

val input = File("Data/DayTwo.txt").readText().split("\n").map {
	it.split(" ")
}

// Shared

sealed class Move {
    open abstract val beats: Move
    open abstract val score: Int
    fun beats(other: Move): Boolean {
		return other == beats
    }
}

object ROCK: Move() { 
    override val beats = SCISSORS 
    override val score = 1
}

object PAPER: Move() { 
    override val beats = ROCK 
    override val score = 2
}

object SCISSORS: Move() { 
    override val beats = PAPER 
    override val score = 3
}

fun move(input: String): Move {
	if (input == "A" || input == "X") {
		return ROCK
	}
    if (input == "B" || input == "Y") {
        return PAPER
	}
    if (input == "C" || input == "Z") {
        return SCISSORS
	}
    throw Exception("You blew it")
}

fun score(us: Move, them: Move): Int {
	if (us.beats(them)) {
		// Win
	    return us.score + 6
	} else if (them.beats(us)) {
		// Lose
	    return us.score
	} else {
		// Draw
	    return us.score + 3
	}	
}

// Part One

val scores1 = input.map {
	score(move(it[1]), move(it[0]))
}

val total = scores1.sum()
println("Total Score 1: " + total)

// Part Two

enum class Result { WIN, LOSE, DRAW }

fun response(other: Move, result: Result): Move {
	val all = arrayOf(ROCK, PAPER, SCISSORS)
	return when(result) {
		Result.WIN -> all.first { it.beats(other) }
		Result.LOSE -> all.first { other.beats(it) }
		Result.DRAW -> other
		else -> throw Exception("You blew it" + result)	
	}
}

val scores2 = input.map {
	val them = move(it[0])
	val result = when(it[1]) {
		"X" -> Result.LOSE
		"Y" -> Result.DRAW
		"Z" -> Result.WIN
		else -> throw Exception("You blew it")
	}
	val us = response(them, result)
	score(us, them)
}

val total2 = scores2.sum()
println("Total Score 2: " + total2)
