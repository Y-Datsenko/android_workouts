package com.datsenko.workouts.utils

import androidx.lifecycle.Observer

open class Event<out T>(private val content: T) {

    private var hasBeenHandled = false

    /**
     * Invokes the action only once at the first time
     */
    fun handleIfNeeded(action: (T) -> Unit) {
        if (!hasBeenHandled) {
            hasBeenHandled = true
            action(content)
        }
    }
}

class SingleEvent : Event<Any>(Any())

class EventObserver<T>(private val action: (T) -> Unit) : Observer<Event<T>> {

    override fun onChanged(t: Event<T>) {
        t.handleIfNeeded(action)
    }
}