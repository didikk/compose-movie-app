package com.example.mymovie.presentation.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.formatDate(format: String): String {
    if (this.isEmpty()) return ""

    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val outputFormat = SimpleDateFormat(format, Locale.getDefault())

    val date: Date? = inputFormat.parse(this)
    val formattedDateString = date?.let { outputFormat.format(it) }

    return formattedDateString ?: ""
}

