package com.datsenko.workouts.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResourceDelegate @Inject constructor(private val appContext: Context) {

    fun getString(@StringRes stringRes: Int): String =
        appContext.getString(stringRes)

    fun getString(@StringRes stringRes: Int, vararg args: Any): String =
        appContext.getString(stringRes, *args)

    fun getQuantityString(@PluralsRes stringRes: Int, quantity: Int, vararg args: Any): String =
        appContext.resources.getQuantityString(stringRes, quantity, *args)

    fun getQuantityString(@PluralsRes stringRes: Int, quantity: Int): String =
        appContext.resources.getQuantityString(stringRes, quantity)

    fun getText(@StringRes stringRes: Int): CharSequence =
        appContext.resources.getText(stringRes)

    fun getText(@StringRes stringRes: Int, def: CharSequence): CharSequence =
        appContext.resources.getText(stringRes, def)

    fun getColor(@ColorRes colorRes: Int): Int =
        ContextCompat.getColor(appContext, colorRes)

    fun getDimensionPixelSize(@DimenRes dimenRes: Int): Int =
        appContext.resources.getDimensionPixelSize(dimenRes)

    fun getInteger(@IntegerRes integerRes: Int): Int =
        appContext.resources.getInteger(integerRes)

    fun getDrawable(@DrawableRes drawableRes: Int): Drawable? =
        ContextCompat.getDrawable(appContext, drawableRes)
}