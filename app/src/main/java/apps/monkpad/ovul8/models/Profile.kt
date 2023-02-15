package apps.monkpad.ovul8.models

import apps.monkpad.ovul8.utils.toDateWithFormat
import java.time.Period

data class Profile(
    val cycleLength: Int = 28,
    val periodsLength: Int = 4,
    val firstDateOfLastCycle: String
){
    fun getElapsedSinceLastPeriodDayOne(currentDate: String): Int{
        val from = firstDateOfLastCycle.toDateWithFormat("dd/MM/yyyy")
        val to = currentDate.toDateWithFormat("dd/MM/yyyy")
        val period = Period.between(from, to)
        return period.days
    }
}
