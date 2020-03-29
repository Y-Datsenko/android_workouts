package com.datsenko.workouts.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WorkoutDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(entity: ExerciseEntity)

    @Query("SELECT * FROM exercises ORDER BY date DESC")
    abstract fun get(): Flow<List<ExerciseEntity>>
}