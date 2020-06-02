package com.datsenko.workouts.presentation.results.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.datsenko.workouts.R

@EpoxyModelClass(layout = R.layout.item_result_empty_list)
abstract class EmptyListEpoxyModel : EpoxyModelWithHolder<EmptyListEpoxyModel.Holder>() {
    class Holder : EpoxyHolder() {
        override fun bindView(itemView: View) {}
    }
}