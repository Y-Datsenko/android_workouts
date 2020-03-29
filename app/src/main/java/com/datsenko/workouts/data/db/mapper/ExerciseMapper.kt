package com.datsenko.workouts.data.db.mapper

import com.datsenko.workouts.data.db.ExerciseEntity
import com.datsenko.workouts.domain.Exercise
import com.datsenko.workouts.utils.Mapper
import javax.inject.Inject

class ExerciseMapper @Inject constructor() : Mapper<Exercise, ExerciseEntity> {
    override fun map(from: Exercise): ExerciseEntity =
        ExerciseEntity(
            repeats = from.repeats,
            date = from.date
        )

    override fun reverse(to: ExerciseEntity): Exercise =
        Exercise(
            date = to.date,
            repeats = to.repeats
        )
}