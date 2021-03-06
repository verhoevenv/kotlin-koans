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

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {
    override infix operator fun contains(value: MyDate): Boolean {
        return start < value && value <= endInclusive
    }

    override operator fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var current = start

            override fun next(): MyDate {
                val res = current
                current = current.nextDay()
                return res
            }

            override fun hasNext(): Boolean = current <= endInclusive
        }
    }
}
