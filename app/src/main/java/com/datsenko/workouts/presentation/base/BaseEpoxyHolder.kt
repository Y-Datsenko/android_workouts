package com.datsenko.workouts.presentation.base

import android.view.View
import com.airbnb.epoxy.EpoxyHolder

open class BaseEpoxyHolder : EpoxyHolder() {

    protected lateinit var itemView: View

    override fun bindView(itemView: View) {
        this.itemView = itemView
    }
}