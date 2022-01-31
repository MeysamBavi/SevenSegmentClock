
/*
    0
  1   3
    2
  4   6
    5
 */


enum class SevenSegmentValue(private val value: Byte) {
    ZERO(0b1111011),
    ONE(0b1001000),
    TWO(0b0111101),
    THREE(0b1101101),
    FOUR(0b1001110),
    FIVE(0b1100111),
    SIX(0b1110111),
    SEVEN(0b1001001),
    EIGHT(0b1111111),
    NINE(0b1101111);

    fun isOn(i: Int) : Boolean = (value.toInt() shr i) and 1 == 1
}

fun fromInt(int: Int) = when(int) {
    0 -> SevenSegmentValue.ZERO
    1 -> SevenSegmentValue.ONE
    2 -> SevenSegmentValue.TWO
    3 -> SevenSegmentValue.THREE
    4 -> SevenSegmentValue.FOUR
    5 -> SevenSegmentValue.FIVE
    6 -> SevenSegmentValue.SIX
    7 -> SevenSegmentValue.SEVEN
    8 -> SevenSegmentValue.EIGHT
    9 -> SevenSegmentValue.NINE
    else -> SevenSegmentValue.EIGHT
}
