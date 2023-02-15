package apps.monkpad.ovul8.models

interface SystemCalendar {
    fun getDayOfWeek(): String
    fun getDateOfWeek(): Int
    fun getCurrentMonth(): String
    fun getTodayDate(): String
}