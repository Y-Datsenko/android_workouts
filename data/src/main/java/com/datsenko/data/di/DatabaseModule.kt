package com.datsenko.data.di

import android.content.Context
import androidx.room.Room
import com.datsenko.data.db.WorkoutDao
import com.datsenko.data.db.WorkoutDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun database(applicationContext: Context): WorkoutDatabase =
        Room.databaseBuilder(
            applicationContext,
            WorkoutDatabase::class.java, "workouts"
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideWorkoutDao(database: WorkoutDatabase): WorkoutDao =
        database.workoutDao()
}