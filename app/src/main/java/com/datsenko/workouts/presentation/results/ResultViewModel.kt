package com.datsenko.workouts.presentation.results

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.datsenko.workouts.di.SingleViewModelFactory
import com.datsenko.workouts.domain.WorkoutRepositoryApi
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Provider

class ResultViewModel(
    private val repository: WorkoutRepositoryApi,
    private val exerciseModelMapper: ExerciseModelMapper
) : ViewModel() {

    val workouts =
        repository.observeExercises()
            .map { it.map(exerciseModelMapper::map) }
            .asLiveData(viewModelScope.coroutineContext)

    init {
        Log.d("logTag", "init $repository")
    }

    class Factory @Inject constructor(
        private val repositoryProvider: Provider<WorkoutRepositoryApi>,
        private val exerciseModelMapper: Provider<ExerciseModelMapper>
    ) : SingleViewModelFactory<ResultViewModel> {

        override fun create(): ResultViewModel =
            ResultViewModel(repository = repositoryProvider.get(), exerciseModelMapper = exerciseModelMapper.get())
    }
}