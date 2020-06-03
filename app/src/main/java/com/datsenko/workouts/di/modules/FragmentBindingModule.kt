package com.datsenko.workouts.di.modules

import com.datsenko.workouts.di.FragmentScope
import com.datsenko.workouts.presentation.newexercise.AddExerciseFragment
import com.datsenko.workouts.presentation.results.ResultFragment
import com.datsenko.workouts.presentation.results.ResultFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ResultFragmentModule::class])
    abstract fun workoutResultFragment(): ResultFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun addExerciseFragment(): AddExerciseFragment
}