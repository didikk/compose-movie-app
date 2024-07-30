package com.example.mymovie.presentation.screens.detail.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun AboutFragment(overview: String) {
    Text(
        fontSize = 12.sp,
        text = overview
    )
}