package com.datsenko.workouts.di.modules

import com.datsenko.workouts.di.ActivityScope
import com.datsenko.workouts.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class])
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentBindingModule::class])
    abstract fun mainActivity(): MainActivity
}