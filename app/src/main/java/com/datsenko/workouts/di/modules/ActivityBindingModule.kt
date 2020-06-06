package com.datsenko.workouts.di.modules

import com.datsenko.workouts.di.ActivityScope
import com.datsenko.workouts.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class])
interface ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentBindingModule::class])
    fun mainActivity(): MainActivity
}