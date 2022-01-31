import java.time.LocalDateTime
import kotlin.concurrent.timer

fun main(args: Array<String>) {
    val time = LocalDateTime.now()!!
    var blinkOn = time.second % 2 == 0
    val withSec = args.any { "sec" in it.lowercase() }

    blink(time, blinkOn, withSec)

    val initialDelay = (1_000_000_000 - time.nano) / 1_000_000L

    timer(initialDelay = initialDelay, period = 1_000) {
        blinkOn = blinkOn.not()
        blink(LocalDateTime.now(), blinkOn, withSec)
    }
}

fun blink(time: LocalDateTime, blinkOn: Boolean, withSec: Boolean) {
    cls()
    with(time) {
        val hour = "$hour".padStart(2, '0')
        val minute = "$minute".padStart(2, '0')
        val second = "$second".padStart(2, '0')

        render("$hour:$minute${if (withSec) ":$second" else ""}", blinkOn)
    }
}

fun cls() {
    ProcessBuilder("cmd.exe", "/c", "cls").inheritIO().start().waitFor()
}