// Day07.kts

import java.io.File

// Shared

val input = File("Data/Day07.txt").readText().split("\n")

val testInput = """
$ cd /
$ ls
dir a
14848514 b.txt
8504156 c.dat
dir d
$ cd a
$ ls
dir e
29116 f
2557 g
62596 h.lst
$ cd e
$ ls
584 i
$ cd ..
$ cd ..
$ cd d
$ ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k
"""
.trim()
.split("\n")

val maxSize = 100000

var pwd : String = ""

val values = testInput.map {
	// Ugh, ugly.
	val line = it
	if (line == "$ cd ..") {
		pwd = pwd.split("/").dropLast(1).joinToString()
		null
	} else if (line.startsWith("$ cd ")) {
		val dir = line.split("$ cd ").last()
		if (dir == "/") {
			pwd = dir
		} else {
			pwd = pwd + dir + "/"	
		}
		null
	} else if (line.startsWith("dir")) {
		null
	} else if (line == "$ ls") {
		null
	} else {
		pwd + line.split(" ").last() + ": " + line.split(" ").first()
	}
}
.filterNotNull()

val paths = values.map {
	val components = it.split(": ")
	components.first()
}

fun firstComponent(input: String): String {
	return input.split(": ").first().split("/").filter { !it.isBlank() }.first()
}

println(paths)

var results : Array<Int> = emptyArray()

for (path in paths) {
	val group = values.filter {
		val x = it.split(": ").first()
		firstComponent(x) == firstComponent(path)
	}
	println("group: " + group)
	val groupSize = group.map { it.split(": ").last().toInt() } .sum()
	if (groupSize <= maxSize) {
		results += groupSize
	} else {
		
	}
}

println(results)

val sizes = values.map {
	val components = it.split(": ")
	val size = components.last()
	if (size.toInt() < maxSize) {
		size
	} else {
		null
	}
}
.filterNotNull()


println(sizes)