package com.example.mymovie.presentation.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mymovie.domain.model.Movie
import com.example.mymovie.presentation.base.DataState
import com.example.mymovie.presentation.components.ErrorView
import com.example.mymovie.presentation.components.Loading
import com.example.mymovie.presentation.components.MovieItem

fun LazyListScope.CategoryCollection(
    modifier: Modifier = Modifier,
    title: String,
    state: DataState<List<Movie>>,
    onItemClick: (Int) -> Unit,
) {
    item {
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            modifier = modifier
                .padding(horizontal = 24.dp)
                .padding(bottom = 16.dp)
        )
    }
    when (state) {
        is DataState.Success -> {
            items(state.data) { movie ->
                MovieItem(
                    movie = movie,
                    modifier = Modifier
                        .padding(start = 24.dp)
                        .padding(bottom = 16.dp)
                        .clickable { onItemClick(movie.id) },
                )
            }
        }

        is DataState.Loading -> {
            item {
                Loading()
            }
        }

        is DataState.Error -> {
            item {
                ErrorView(text = state.error)
            }
        }
    }
}