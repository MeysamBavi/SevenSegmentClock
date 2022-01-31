import kotlin.time.Duration.Companion.milliseconds

fun render(value: SevenSegmentValue) : Unit {
    print(' ')
    print(value.character(0))
    print(' ')
    println()

    print(value.character(1))
    print(value.character(2))
    print(value.character(3))
    println()

    print(value.character(4))
    print(value.character(5))
    print(value.character(6))
    println()
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