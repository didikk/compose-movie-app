package com.example.mymovie.presentation.screens.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.mymovie.presentation.components.Header
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteScreen(viewModel: FavoriteViewModel = koinViewModel()) {
    val favoriteMovies by viewModel.favoriteMovies.collectAsState()

    Column {
        Header(title = "Favorite")
//        LazyColumn(contentPadding = PaddingValues(top = 24.dp)) {
//            items(5) {
//                MovieItem(
//                    modifier = Modifier
//                        .padding(horizontal = 24.dp)
//                        .padding(bottom = 24.dp)
//                )
//            }
//        }
    }
}