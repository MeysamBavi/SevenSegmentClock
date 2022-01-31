import java.time.LocalDateTime
import kotlin.concurrent.timer

fun main() {
    val time = LocalDateTime.now()!!
    var blinkOn = time.second % 2 == 0

    blink(time, blinkOn)

    val initialDelay = (1_000_000_000 - time.nano) / 1_000_000L

    timer(initialDelay = initialDelay, period = 1_000) {
        blinkOn = blinkOn.not()
        blink(LocalDateTime.now(), blinkOn)
    }
}

fun blink(time: LocalDateTime, blinkOn: Boolean) {
    cls()
    with(time) {
        render("$hour:$minute", blinkOn)
    }
}

fun cls() {
    ProcessBuilder("cmd.exe", "/c", "cls").inheritIO().start().waitFor()
}