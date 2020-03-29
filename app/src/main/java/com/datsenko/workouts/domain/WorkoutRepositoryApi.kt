package com.datsenko.workouts.domain

import kotlinx.coroutines.flow.Flow

interface WorkoutRepositoryApi {

    suspend fun insert(exercise: Exercise)

    fun observeExercises(): Flow<List<Exercise>>
}