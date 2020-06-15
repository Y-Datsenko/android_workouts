package com.datsenko.workouts.presentation.results.epoxy

import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.datsenko.workouts.R
import com.datsenko.workouts.presentation.base.BaseEpoxyHolder

@EpoxyModelClass(layout = R.layout.item_result_empty_list)
abstract class EmptyListEpoxyModel : EpoxyModelWithHolder<BaseEpoxyHolder>()