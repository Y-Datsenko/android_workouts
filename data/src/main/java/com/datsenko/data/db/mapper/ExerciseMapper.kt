package com.datsenko.data.db.mapper

import com.datsenko.data.db.ExerciseEntity
import com.datsenko.domain.Exercise
import com.datsenko.domain.utils.Mapper
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