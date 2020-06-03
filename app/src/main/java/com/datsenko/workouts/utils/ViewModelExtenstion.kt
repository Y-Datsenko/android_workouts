package com.datsenko.workouts.utils

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.savedstate.SavedStateRegistryOwner

inline fun <reified T : ViewModel> SavedStateRegistryOwner.createAbstractSavedStateViewModelFactory(
    arguments: Bundle,
    crossinline creator: (SavedStateHandle) -> T
): ViewModelProvider.Factory {
    return object : AbstractSavedStateViewModelFactory(this, arguments) {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(
            key: String, modelClass: Class<T>, handle: SavedStateHandle
        ): T = creator(handle) as T
    }
}

inline fun <reified T : ViewModel> Fragment.navGraphSavedStateViewModels(
    @IdRes navGraphId: Int,
    crossinline creator: (SavedStateHandle) -> T
): Lazy<T> {
    // Wrapped in lazy to not search the NavController each time we want the backStackEntry
    val backStackEntry by lazy { findNavController().getBackStackEntry(navGraphId) }

    return createViewModelLazy(T::class, storeProducer = {
        backStackEntry.viewModelStore
    }, factoryProducer = {
        backStackEntry.createAbstractSavedStateViewModelFactory(
            arguments = backStackEntry.arguments ?: Bundle(), creator = creator
        )
    })
}

inline fun <reified T : ViewModel> Fragment.fragmentSavedStateViewModels(
    crossinline creator: (SavedStateHandle) -> T
): Lazy<T> {
    return createViewModelLazy(T::class, storeProducer = {
        viewModelStore
    }, factoryProducer = {
        createAbstractSavedStateViewModelFactory(arguments ?: Bundle(), creator)
    })
}