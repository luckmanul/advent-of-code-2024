
fun main(args: Array<String>) {
    val d = Day2()
    val input = d.readInput()

    d.part1(input)
    d.part2(input)
}

class Day2 {

    fun part1(input: Day2Input) {
        val lines = input.lines
        var safe = 0
        for (line in lines) {
            val items = parseLine(line)
            if (isSafe(items)) {
                safe++
            }
        }
        println("safe = $safe")
    }

    fun part2(input: Day2Input) {
        val lines = input.lines
        var safe = 0
        for (line in lines) {
            val items = parseLine(line)
            if (isSafe(items)) {
                safe++
            } else if (isSafeFix(items)) {
                safe++
            }
        }
        println("safe = $safe")
    }

    fun isSafeFix(items: List<Int>): Boolean {
        var removeIndex = 0
        while (removeIndex < items.size) {
            val newItems = ArrayList(items)
            newItems.removeAt(removeIndex)
            if (isSafe(newItems)) {
                return true
            }
            removeIndex++
        }
        return false
    }

    fun isSafe(items: List<Int>): Boolean {
        var defaultIncrement = false
        for (start in items.indices) {
            val end = start + 1
            if (end < items.size) {
                val distance = items[start] - items[end]
                if (distance == 0) {
                    return false
                }
                if (start == 0) defaultIncrement = distance < 0
                val increment = distance < 0
                if (defaultIncrement != increment) return false
                if (Math.abs(distance) > 3) return false
            }
        }
        return true
    }

    fun parseLine(line: String): List<Int> {
        val result = ArrayList<Int>()
        val items = line.split(" ").toTypedArray()
        for (item in items) {
            result.add(item.toInt())
        }
        return result
    }

    fun readInput(): Day2Input {
        val lines = readInput("day02")
        val result = Day2Input()

        result.lines = lines;

        return result
    }

    class Day2Input {

        var lines: List<String> = ArrayList()

    }
}
