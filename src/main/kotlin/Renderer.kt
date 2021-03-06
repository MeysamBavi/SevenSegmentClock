
fun render(str: String, blinkOn : Boolean = true) : Unit {
    var index = 0
    var indicesOfColon = mutableListOf<Int>()
    val segmentList : List<SevenSegmentValue> = str.mapNotNull lambda@{
        if (it.isDigit()) {
            index++
            return@lambda fromInt(it.digitToInt())
        }

        if (it == ':') {
            indicesOfColon.add(index - indicesOfColon.size)
            index++
        }

        return@lambda null
    }

    return render(segmentList, indicesOfColon, blinkOn)
}

fun render(values: List<SevenSegmentValue>, indicesOfColon: List<Int>, blinkOn: Boolean = true) : Unit {
    values.forEachIndexed {
        index, value ->

        if (index in indicesOfColon) {
            print(' ')
            print(' ')
        }

        renderTop(value.character(0))
        print(' ')
    }

    println()

    values.forEachIndexed {
        index, value ->

        if (index in indicesOfColon) {
            print(if (blinkOn) ". " else "  ")
        }

        renderMid(value.character(1), value.character(2), value.character(3))
        print(' ')
    }

    println()

    values.forEachIndexed {
        index, value ->

        if (index in indicesOfColon) {
            print(if (blinkOn) ". " else "  ")
        }

        renderMid(value.character(4), value.character(5), value.character(6))
        print(' ')
    }

    println()
}

private fun renderTop(char: Char) : Unit {
    print(' ')
    print(char)
    print(' ')
}

private fun renderMid(char1 : Char, char2 : Char, char3 : Char) : Unit {
    print(char1)
    print(char2)
    print(char3)
}

fun SevenSegmentValue.character(segment: Int) : Char {
    return if (isOn(segment)) {
        when(segment) {
            0, 2, 5 -> '_'
            else -> '|'
        }
    } else {
        ' '
    }
}