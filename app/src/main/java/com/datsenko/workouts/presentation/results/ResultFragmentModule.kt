package com.datsenko.workouts.presentation.results

import com.datsenko.workouts.di.StatelessViewModelFactory
import com.datsenko.workouts.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ResultFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(ResultViewModel::class)
    abstract fun bindResultViewModel(factory: ResultViewModel.Factory): StatelessViewModelFactory<*>
}