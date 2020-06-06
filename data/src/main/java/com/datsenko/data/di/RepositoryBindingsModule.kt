package com.datsenko.data.di

import com.datsenko.data.WorkoutRepository
import com.datsenko.domain.WorkoutRepositoryApi
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryBindingsModule {

    @Binds
    @Singleton
    abstract fun bindResultViewModel(repository: WorkoutRepository): WorkoutRepositoryApi
}