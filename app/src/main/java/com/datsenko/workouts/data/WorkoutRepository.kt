package com.datsenko.workouts.data

import com.datsenko.workouts.data.db.WorkoutDao
import com.datsenko.workouts.data.db.mapper.ExerciseMapper
import com.datsenko.workouts.domain.Exercise
import com.datsenko.workouts.domain.WorkoutRepositoryApi
import com.datsenko.workouts.utils.DateFormatter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorkoutRepository @Inject constructor(
    private val workoutDao: WorkoutDao,
    private val exerciseMapper: ExerciseMapper,
    private val dateFormatter: DateFormatter
) : WorkoutRepositoryApi {

    override suspend fun insert(exercise: Exercise) {
        workoutDao.insert(exerciseMapper.map(exercise))
    }

    override fun observeExercises(): Flow<List<Exercise>> =
        workoutDao.get().map { it ->
            val group = it.map(exerciseMapper::reverse)
                .groupBy { dateFormatter.formatToFullDateStr(it.date) }
            group.keys.map {
                Exercise(
                    date = group[it]!!.first().date,
                    repeats = group[it]!!.sumBy(Exercise::repeats)
                )
            }
        }
}