package com.datsenko.data.db

import androidx.room.TypeConverter
import java.util.Date

class Converters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? =
        value?.let(::Date)

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? =
        date?.time
}