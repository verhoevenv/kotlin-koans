package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return when {
            year.compareTo(other.year) != 0 -> year.compareTo(other.year)
            month.compareTo(other.month) != 0 -> month.compareTo(other.month)
            dayOfMonth.compareTo(other.dayOfMonth) != 0 -> dayOfMonth.compareTo(other.dayOfMonth)
            else -> 0
        }
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)
