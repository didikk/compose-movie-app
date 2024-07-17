package com.example.mymovie.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MovieList(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(5) {
            MovieItem()
        }
    }
}
