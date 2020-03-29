package com.datsenko.workouts.di.modules

import com.datsenko.workouts.data.WorkoutRepository
import com.datsenko.workouts.domain.WorkoutRepositoryApi
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryBindingsModule {

    @Binds
    @Singleton
    abstract fun bindResultViewModel(repository: WorkoutRepository): WorkoutRepositoryApi
}