package com.datsenko.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "exercises")
class ExerciseEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "date") val date: Date,
    @ColumnInfo(name = "repeats") val repeats: Int
)