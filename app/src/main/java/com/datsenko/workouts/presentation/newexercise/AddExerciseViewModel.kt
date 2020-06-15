package com.datsenko.workouts.presentation.newexercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.datsenko.domain.Exercise
import com.datsenko.domain.WorkoutRepositoryApi
import com.datsenko.workouts.di.StatefulViewModelFactory
import com.datsenko.workouts.utils.SingleEvent
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.launch
import java.util.Date

class AddExerciseViewModel @AssistedInject constructor(
    private val repository: WorkoutRepositoryApi,
    @Assisted private val handle: SavedStateHandle
) : ViewModel() {

    companion object {
        const val ARG_REPEATS = "ARG_REPEATS"
        const val ARG_IS_ADDING = "ARG_IS_ADDING"
    }

    private var _closeEvent = MutableLiveData<SingleEvent>()
    private val _repeats: LiveData<Int> = handle.getLiveData(ARG_REPEATS, 0)

    val repeats: LiveData<String> = Transformations.map(_repeats) { it.toString() }
    val isAddingMode: LiveData<Boolean> = handle.getLiveData(ARG_IS_ADDING, true)
    val closeEvent: LiveData<SingleEvent> = _closeEvent

    fun onOnePressed() {
        changeCount(1)
    }

    fun onTenPressed() {
        changeCount(10)
    }

    fun onTwentyPressed() {
        changeCount(20)
    }

    fun onSwitchModeChanged(checked: Boolean) {
        handle.set(ARG_IS_ADDING, checked)
    }

    fun onSaveClicked() {
        viewModelScope.launch {
            val repeats = _repeats.value ?: 0
            if (repeats > 0) {
                val entity = Exercise(date = Date(), repeats = _repeats.value ?: 0)
                repository.insert(entity)
            }
            _closeEvent.postValue(SingleEvent())
        }
    }

    private fun changeCount(delta: Int) {
        val deltaValue = if (isAddingMode.value == true) delta else -delta
        val tempValue = _repeats.value?.let { it + deltaValue } ?: 0
        val newValue = if (tempValue < 0) 0 else tempValue
        handle.set(ARG_REPEATS, newValue)
    }

    @AssistedInject.Factory
    interface Factory : StatefulViewModelFactory<AddExerciseViewModel>
}