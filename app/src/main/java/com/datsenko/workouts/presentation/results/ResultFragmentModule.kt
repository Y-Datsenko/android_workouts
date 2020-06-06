package com.datsenko.workouts.presentation.results

import com.datsenko.workouts.di.StatelessViewModelFactory
import com.datsenko.workouts.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ResultFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(ResultViewModel::class)
    fun bindResultViewModel(factory: ResultViewModel.Factory): StatelessViewModelFactory<*>
}