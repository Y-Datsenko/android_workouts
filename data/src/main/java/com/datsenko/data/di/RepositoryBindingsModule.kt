package com.datsenko.data.di

import com.datsenko.data.WorkoutRepository
import com.datsenko.domain.WorkoutRepositoryApi
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryBindingsModule {

    @Binds
    @Singleton
    fun bindResultViewModel(repository: WorkoutRepository): WorkoutRepositoryApi
}