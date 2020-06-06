package com.datsenko.workouts.presentation.results

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.datsenko.domain.WorkoutRepositoryApi
import com.datsenko.workouts.di.StatelessViewModelFactory
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

    @AssistedInject.Factory
    interface Factory : StatelessViewModelFactory<ResultViewModel>
}