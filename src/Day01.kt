fun main() {
    val d = Day1();
    val input = d.readInput()

    d.part1(input)
    d.part2(input)
}

class Day1 {
    fun part1(input: Day1Input) {
        val leftList = input.sortedLeft
        val rightList = input.sortedRight

        var total = 0
        for (i in leftList.indices) {
            val left = leftList[i]
            val right = rightList[i]
            val distance = kotlin.math.abs(left - right)
            total += distance
        }
        println("total = $total")
    }

    fun part2(input: Day1Input) {
        val leftList = input.left
        val rightList = input.right
        val similarityMap = mutableMapOf<Int, Int>()

        for (i in leftList.indices) {
            val right = rightList[i]
            similarityMap[right] = similarityMap.getOrDefault(right, 0) + 1
        }
        var total = 0
        for (i in leftList.indices) {
            val left = leftList[i]
            val multiplier = similarityMap.getOrDefault(left, 0)
            total += left * multiplier
        }
        println("total = $total")
    }

    fun readInput(): Day1Input {

        val lines = readInput("day01")
        val result = Day1Input()

        for (line in lines) {
            val arr = line!!.split("   ").toTypedArray()
            if (arr[0].isNotBlank() && arr[1].isNotBlank()) {
                result.addLeft(arr[0].toInt())
                result.addRight(arr[1].toInt())
            }
        }
        return result
    }

    class Day1Input {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()

        fun addLeft(value: Int) {
            left.add(value)
        }

        fun addRight(value: Int) {
            right.add(value)
        }

        val sortedLeft: List<Int>
            get() = left.sorted()

        val sortedRight: List<Int>
            get() = right.sorted()
    }
}
