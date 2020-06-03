package com.datsenko.workouts.di

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface StatefulViewModelFactory<V : ViewModel> {
    fun create(handle: SavedStateHandle): V
}

interface StatelessViewModelFactory<V : ViewModel> {
    fun create(): V
}