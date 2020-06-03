package com.datsenko.workouts.di.modules

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@AssistedModule
@Module(includes = [AssistedInject_ViewModelsModule::class])
interface ViewModelsModule