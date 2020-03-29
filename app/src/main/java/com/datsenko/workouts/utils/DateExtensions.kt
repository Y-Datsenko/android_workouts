package com.datsenko.workouts.utils

import androidx.annotation.IntRange
import java.util.Calendar
import java.util.Date

val Date.isToday: Boolean
    get() = isTheDay(time, 0)

val Date.isTomorrow: Boolean
    get() = isTheDay(time, 1)

val Date.isYesterday: Boolean
    get() = isTheDay(time, -1)


private fun isTheDay(time: Long, @IntRange(from = -1, to = 1) period: Int): Boolean {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = time

    val thenYear = calendar.get(Calendar.YEAR)
    val thenMonth = calendar.get(Calendar.MONTH)
    val thenMonthDay = calendar.get(Calendar.DAY_OF_MONTH)

    calendar.timeInMillis = System.currentTimeMillis()
    calendar.add(Calendar.DAY_OF_MONTH, period)
    return (thenYear == calendar.get(Calendar.YEAR)
            && thenMonth == calendar.get(Calendar.MONTH)
            && thenMonthDay == calendar.get(Calendar.DAY_OF_MONTH))
}
