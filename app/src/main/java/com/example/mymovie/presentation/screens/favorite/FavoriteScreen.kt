package com.example.mymovie.presentation.screens.favorite

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mymovie.presentation.components.Header
import com.example.mymovie.presentation.components.MovieItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteScreen(toDetail: (Int) -> Unit, viewModel: FavoriteViewModel = koinViewModel()) {
    val favoriteMovies by viewModel.favoriteMovies.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getFavoriteMovies()
    }

    Column {
        Header(title = "Favorite")
        LazyColumn(contentPadding = PaddingValues(top = 24.dp)) {
            items(favoriteMovies) {
                MovieItem(
                    movie = it,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(bottom = 24.dp)
                        .clickable { toDetail(it.id) }
                )
            }
        }
    }
}