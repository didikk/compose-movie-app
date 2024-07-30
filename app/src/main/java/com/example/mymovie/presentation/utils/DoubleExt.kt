package com.example.mymovie.presentation.utils

import java.util.Locale

fun Double.formatRating(): String {
    return String.format(Locale.getDefault(), "%.1f", this)
}