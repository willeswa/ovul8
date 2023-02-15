package apps.monkpad.ovul8.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun String.toDateWithFormat(format: String = "dd/MM/yyyy"): LocalDate = let {
    val dateFormatter = DateTimeFormatter.ofPattern(format)
    return LocalDate.parse(it, dateFormatter)
}