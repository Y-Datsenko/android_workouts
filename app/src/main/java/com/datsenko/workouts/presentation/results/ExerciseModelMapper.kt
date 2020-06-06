package com.datsenko.workouts.presentation.results

import com.datsenko.domain.Exercise
import com.datsenko.domain.utils.BaseMapper
import com.datsenko.workouts.presentation.results.model.ExerciseModel
import com.datsenko.workouts.utils.DateFormatter
import javax.inject.Inject

class ExerciseModelMapper @Inject constructor(
    private val dateFormatter: DateFormatter
) : BaseMapper<Exercise, ExerciseModel> {

    override fun map(from: Exercise): ExerciseModel =
        ExerciseModel(
            repeatsCount = from.repeats.toString(),
            timestamp = dateFormatter.formatToDayMonthReadableDayOfWeekStr(from.date)
        )
}