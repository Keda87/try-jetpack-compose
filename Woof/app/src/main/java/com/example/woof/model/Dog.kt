package com.example.woof.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Dog(
    @DrawableRes val imageResId: Int,
    @StringRes val nameResId: Int,
    val age: Int,
    @StringRes val hobbiesResId: Int
)