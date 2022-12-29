package com.example.buildagrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val strResId: Int,
    val count: Int,
    @DrawableRes val imgResId: Int,
)
