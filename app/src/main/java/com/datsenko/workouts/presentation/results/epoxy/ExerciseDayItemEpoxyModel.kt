package com.datsenko.workouts.presentation.results.epoxy

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.datsenko.workouts.R
import com.datsenko.workouts.presentation.results.model.ExerciseModel

@EpoxyModelClass(layout = R.layout.item_workout_day_summary)
abstract class ExerciseDayItemEpoxyModel : EpoxyModelWithHolder<ExerciseDayItemEpoxyModel.Holder>() {

    @EpoxyAttribute lateinit var model: ExerciseModel

    override fun bind(holder: Holder) {
        holder.repeatsValue.text = model.repeatsCount
        holder.exerciseTime.text = model.timestamp
    }

    class Holder : EpoxyHolder() {
        lateinit var repeatsValue: TextView
        lateinit var exerciseTime: TextView

        override fun bindView(itemView: View) {
            with(itemView) {
                repeatsValue = findViewById(R.id.repeats_value)
                exerciseTime = findViewById(R.id.exercise_time)
            }
        }
    }
}