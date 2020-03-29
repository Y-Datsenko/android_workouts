package com.datsenko.workouts.di

import androidx.lifecycle.ViewModel

interface SingleViewModelFactory<V : ViewModel> {
    fun create(): V
}