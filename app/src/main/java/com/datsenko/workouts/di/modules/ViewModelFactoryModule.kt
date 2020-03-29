package com.datsenko.workouts.di.modules

import androidx.lifecycle.ViewModelProvider
import com.datsenko.workouts.di.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}