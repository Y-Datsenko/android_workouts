package com.datsenko.workouts.presentation.results.epoxy

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.datsenko.workouts.R
import com.datsenko.workouts.presentation.base.BaseEpoxyHolder
import com.datsenko.workouts.presentation.results.model.ExerciseModel

@EpoxyModelClass(layout = R.layout.item_result_workout)
abstract class ExerciseItemEpoxyModel : EpoxyModelWithHolder<ExerciseItemEpoxyModel.Holder>() {

    @EpoxyAttribute lateinit var model: ExerciseModel

    override fun bind(holder: Holder) {
        holder.repeatsValue.text = model.repeatsCount
        holder.exerciseTime.text = model.timestamp
    }

    class Holder : BaseEpoxyHolder() {
        val repeatsValue by lazy { itemView.findViewById(R.id.repeats_value) as TextView }
        val exerciseTime by lazy { itemView.findViewById(R.id.exercise_time) as TextView }
    }
}