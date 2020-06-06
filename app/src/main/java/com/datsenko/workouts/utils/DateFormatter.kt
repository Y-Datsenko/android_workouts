package com.datsenko.workouts.utils

import androidx.annotation.StringRes
import com.datsenko.domain.utils.isToday
import com.datsenko.domain.utils.isTomorrow
import com.datsenko.domain.utils.isYesterday
import com.datsenko.workouts.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DateFormatter @Inject constructor(
    private val resourceDelegate: ResourceDelegate
) {

    fun formatToMonthDayOfWeekStr(date: Date): String {
        return getDateFormat(R.string.date_pattern_month_day_of_week).format(date)
    }

    fun formatTo24HoursTime(date: Date): String {
        return getDateFormat(R.string.time_pattern_24).format(date)
    }

    fun formatToFullDateStr(date: Date): String {
        return getDateFormat(R.string.date_pattern_full_date).format(date)
    }

    fun formatToDayMonthReadableDayOfWeekStr(date: Date): String {
        return replaceDayOfWeekByReadable(
            date,
            getDateFormat(R.string.date_pattern_day_month_day_name).format(date)
        )
    }

    private fun getDateFormat(@StringRes datePatternResId: Int): SimpleDateFormat {
        val datePattern: String = resourceDelegate.getString(datePatternResId)
        return SimpleDateFormat(datePattern, Locale.getDefault())
    }

    private fun replaceDayOfWeekByReadable(
        date: Date,
        dateStr: String
    ): String {
        val readableDayOfWeek = when {
            date.isToday -> resourceDelegate.getString(R.string.today)
            date.isTomorrow -> resourceDelegate.getString(R.string.tomorrow)
            date.isYesterday -> resourceDelegate.getString(R.string.yesterday)
            else -> return dateStr
        }
        return dateStr.replace(
            getDateFormat(R.string.date_pattern_day_of_week).format(date),
            readableDayOfWeek
        )
    }
}