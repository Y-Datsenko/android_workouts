package com.datsenko.workouts.di

import android.content.Context
import com.datsenko.data.di.DatabaseModule
import com.datsenko.data.di.RepositoryBindingsModule
import com.datsenko.workouts.di.modules.ActivityBindingModule
import com.datsenko.workouts.di.modules.ViewModelFactoryModule
import com.datsenko.workouts.di.modules.ViewModelsModule
import com.datsenko.workouts.presentation.AndroidApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ActivityBindingModule::class,
        ViewModelFactoryModule::class,
        ViewModelsModule::class,
        DatabaseModule::class,
        RepositoryBindingsModule::class]
)
interface AppComponent : AndroidInjector<AndroidApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

}