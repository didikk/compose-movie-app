package com.example.mymovie.presentation.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mymovie.presentation.components.Header
import com.example.mymovie.presentation.components.MovieItem
import com.example.mymovie.presentation.components.SearchBar

@Composable
fun SearchScreen() {
    Column {
        Header(title = "Search")
        SearchBar(modifier = Modifier.padding(24.dp))
        LazyColumn {
            items(5) {
                MovieItem(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(bottom = 24.dp)
                )
            }
        }
    }
}