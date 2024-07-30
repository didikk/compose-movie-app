package com.example.mymovie.presentation.screens.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mymovie.presentation.components.Header
import com.example.mymovie.presentation.components.MovieItem

@Composable
fun FavoriteScreen() {
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