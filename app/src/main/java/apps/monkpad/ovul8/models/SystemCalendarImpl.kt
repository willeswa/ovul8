package apps.monkpad.ovul8.models

class SystemCalendarImpl: SystemCalendar {
    override fun getDayOfWeek(): String {
        return "Wednesday"
    }

    override fun getDateOfWeek(): Int {
        return 15
    }

    override fun getCurrentMonth(): String {
        return "February"
    }

    override fun getTodayDate(): String {
        return "15/02/2023"
    }
}