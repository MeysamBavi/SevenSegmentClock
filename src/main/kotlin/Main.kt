fun main() {
    for (value in enumValues<SevenSegmentValue>()) {
        render(value)
    }
}