package com.datsenko.workouts.di.modules

import androidx.lifecycle.ViewModelProvider
import com.datsenko.workouts.di.DaggerStatelessViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {
    @Binds
    fun bindViewModelFactory(viewModelFactory: DaggerStatelessViewModelFactory): ViewModelProvider.Factory
}