package com.datsenko.workouts.presentation.newexercise

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.datsenko.workouts.di.SingleViewModelFactory
import com.datsenko.workouts.domain.Exercise
import com.datsenko.workouts.domain.WorkoutRepositoryApi
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject
import javax.inject.Provider

class AddExerciseViewModel(
    private val repository: WorkoutRepositoryApi
) : ViewModel() {

    private var _repeats = MutableLiveData<Int>()
    val repeats: LiveData<String> = Transformations.map(_repeats) { it.toString() }
    private var _isAddingMode = MutableLiveData<Boolean>()
    val isAddingMode: LiveData<Boolean> = _isAddingMode
    private var _closeEvent = MutableLiveData<Any>()
    val closeEvent: LiveData<Any> = _closeEvent

    init {
        _isAddingMode.value = true
        _repeats.value = 0
        Log.d("logTag", "init $repository")
    }

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
        _isAddingMode.postValue(checked)
    }

    fun onSaveClicked() {
        viewModelScope.launch {
            val repeats = _repeats.value ?: 0
            if (repeats > 0) {
                val entity = Exercise(date = Date(), repeats = _repeats.value ?: 0)
                repository.insert(entity)
            }
            _closeEvent.postValue(Any())
        }
    }

    private fun changeCount(delta: Int) {
        val deltaValue = if (isAddingMode.value == true) delta else -delta
        val tempValue = _repeats.value?.let { it + deltaValue } ?: 0
        val newValue = if (tempValue < 0) 0 else tempValue
        _repeats.postValue(newValue)
    }

    class Factory @Inject constructor(
        private val repositoryProvider: Provider<WorkoutRepositoryApi>
    ) : SingleViewModelFactory<AddExerciseViewModel> {

        override fun create(): AddExerciseViewModel =
            AddExerciseViewModel(repository = repositoryProvider.get())
    }
}