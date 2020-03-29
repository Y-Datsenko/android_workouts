package com.datsenko.workouts.utils

interface BaseMapper<From, To> {

    fun map(from: From): To
}

interface Mapper<From, To> : BaseMapper<From, To> {

    fun reverse(to: To): From
}