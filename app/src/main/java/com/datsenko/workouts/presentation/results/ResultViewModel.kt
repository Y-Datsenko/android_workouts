package com.datsenko.workouts.presentation.results

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.datsenko.workouts.di.StatelessViewModelFactory
import com.datsenko.workouts.domain.WorkoutRepositoryApi
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.flow.map

class ResultViewModel @AssistedInject constructor(
    repository: WorkoutRepositoryApi,
    private val exerciseModelMapper: ExerciseModelMapper
) : ViewModel() {

    val workouts =
        repository.observeExercises()
            .map { it.map(exerciseModelMapper::map) }
            .asLiveData(viewModelScope.coroutineContext)

    init {
        Log.d("logTag", "init $repository")
    }

    @AssistedInject.Factory
    interface Factory : StatelessViewModelFactory<ResultViewModel>
}