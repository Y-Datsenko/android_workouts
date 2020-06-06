package com.datsenko.data

import com.datsenko.data.db.WorkoutDao
import com.datsenko.data.db.mapper.ExerciseMapper
import com.datsenko.domain.Exercise
import com.datsenko.domain.WorkoutRepositoryApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.text.SimpleDateFormat
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorkoutRepository @Inject constructor(
    private val workoutDao: WorkoutDao,
    private val exerciseMapper: ExerciseMapper
) : WorkoutRepositoryApi {

    private val dateFormatter: SimpleDateFormat
        get() = SimpleDateFormat("yyyy.MM.dd")

    override suspend fun insert(exercise: Exercise) {
        workoutDao.insert(exerciseMapper.map(exercise))
    }

    override fun observeExercises(): Flow<List<Exercise>> =
        workoutDao.get().map { it ->
            val group = it.map(exerciseMapper::reverse)
                .groupBy { dateFormatter.format(it.date) }
            group.keys.map {
                Exercise(
                    date = group[it]!!.first().date,
                    repeats = group[it]!!.sumBy(Exercise::repeats)
                )
            }
        }
}