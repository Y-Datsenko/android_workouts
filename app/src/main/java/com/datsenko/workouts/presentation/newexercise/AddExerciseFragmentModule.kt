package com.datsenko.workouts.presentation.newexercise

import com.datsenko.workouts.di.SingleViewModelFactory
import com.datsenko.workouts.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AddExerciseFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(AddExerciseViewModel::class)
    abstract fun bindResultViewModel(factory: AddExerciseViewModel.Factory): SingleViewModelFactory<*>
}