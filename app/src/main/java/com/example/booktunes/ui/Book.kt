package com.example.booktunes.ui

import androidx.annotation.DrawableRes

data class Book(
    val name: String,
    @DrawableRes
    val cover: Int?
)
