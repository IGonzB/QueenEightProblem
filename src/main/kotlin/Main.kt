val forbiddenPoints = mutableSetOf<Pair<Int, Int>>()
fun main(args: Array<String>) {

    // Solution
    //val array = arrayOf("(1,2)", "(2,4)" , "(3,6)","(4,8)","(5,3)","(6,1)","(8,5)","(7,7)")

    //val array = arrayOf("(1,1)",  "(8,8)")
    val array = arrayOf("(1,2)", "(2,4)", "(3,6)", "(4,8)", "(5,3)", "(6,1)", "(8,1)", "(7,7)")

    val pairs = array.map {
        Pair(it[1].digitToInt(), it[3].digitToInt())
    }
    pairs.forEach {
        val x = it.first
        val y = it.second

        println("-------------[x,y]---------------")
        println("-------------[$x,$y]---------------")
        forbiddenPoints.addAll(getTopRightDiagonals(it))
        forbiddenPoints.addAll(getBottomLeftDiagonals(it))
        forbiddenPoints.addAll(getTopLeftDiagonals(it))
        forbiddenPoints.addAll(getBottomRightDiagonals(it))
        forbiddenPoints.addAll(getTop(it))
        forbiddenPoints.addAll(getBottom(it))
        forbiddenPoints.addAll(getRight(it))
        forbiddenPoints.addAll(getLeft(it))

        if (forbiddenPoints.contains(it)) {
            println("Queen Collision found for ($x,$y) point")
            return
        }
        forbiddenPoints.add(it)
    }
    println("Queen Collision NOT found")
}

fun getRight(point: Pair<Int, Int>): List<Pair<Int, Int>> {
    var x = point.first
    var y = point.second
    var r = mutableListOf<Pair<Int, Int>>()
    for (i in 1..8) {
        if (x == 8) {
            return r
        }
        x++
        r.add(Pair(x, point.second))
        println("→($x:$y)")
    }
    return r
}

fun getLeft(point: Pair<Int, Int>): List<Pair<Int, Int>> {
    var x = point.first
    var y = point.second
    var r = mutableListOf<Pair<Int, Int>>()
    for (i in 1..8) {
        if (x == 1) {
            return r
        }
        x--
        r.add(Pair(x, point.second))
        println("←($x:$y)")
    }
    return r
}

fun getTop(point: Pair<Int, Int>): List<Pair<Int, Int>> {
    val x = point.first
    var y = point.second
    val r = mutableListOf<Pair<Int, Int>>()
    for (i in 1..8) {
        if (y == 8) {
            return r
        }
        y++
        r.add(Pair(point.first, y))
        println("↑($x:$y)")
    }
    return r
}

fun getBottom(point: Pair<Int, Int>): List<Pair<Int, Int>> {
    val x = point.first
    var y = point.second
    val r = mutableListOf<Pair<Int, Int>>()
    for (i in 1..8) {
        if (y == 1) {
            return r
        }
        y--
        r.add(Pair(point.first, y))
        println("↓($x:$y)")
    }
    return r
}

fun getBottomRightDiagonals(point: Pair<Int, Int>): List<Pair<Int, Int>> {
    var x = point.first
    var y = point.second
    val r = mutableListOf<Pair<Int, Int>>()
    for (i in 1..8) {
        if (x == 8 || y == 1) {
            return r
        }
        x++
        y--
        r.add(Pair(x, y))
        println("↘($x:$y)")
    }
    return r
}

fun getTopRightDiagonals(point: Pair<Int, Int>): List<Pair<Int, Int>> {
    var x = point.first
    var y = point.second
    val r = mutableListOf<Pair<Int, Int>>()
    for (i in 1..8) {
        if (x == 8 || y == 8) {
            return r
        }
        x++
        y++
        r.add(Pair(x, y))
        println("↗($x:$y)")
    }
    return r
}

fun getTopLeftDiagonals(point: Pair<Int, Int>): List<Pair<Int, Int>> {
    var x = point.first
    var y = point.second
    val r = mutableListOf<Pair<Int, Int>>()
    for (i in 1..8) {
        if (x == 1 || y == 8) {
            return r
        }
        x--
        y++
        r.add(Pair(x, y))
        println("↖($x:$y)")
    }
    return r
}

fun getBottomLeftDiagonals(point: Pair<Int, Int>): List<Pair<Int, Int>> {
    var x = point.first
    var y = point.second
    val r = mutableListOf<Pair<Int, Int>>()
    for (i in 1..8) {
        if (x == 1 || y == 1) {
            return r
        }
        x--
        y--
        r.add(Pair(x, y))
        println("↙($x:$y)")
    }
    return r
}




