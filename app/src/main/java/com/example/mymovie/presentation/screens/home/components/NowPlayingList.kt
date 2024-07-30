package com.example.mymovie.presentation.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mymovie.domain.model.Movie
import com.example.mymovie.presentation.base.DataState
import com.example.mymovie.presentation.components.ErrorView
import com.example.mymovie.presentation.components.Loading

@Composable
fun NowPlayingList(
    modifier: Modifier = Modifier,
    state: DataState<List<Movie>>,
    onItemClick: (Int) -> Unit
) {
    Text(
        text = "Now Playing",
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
            .padding(bottom = 16.dp)
            .padding(horizontal = 24.dp)
    )
    when (state) {
        is DataState.Success -> {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.data) { movie ->
                    AsyncImage(
                        model = movie.getPosterUrl(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(100.dp)
                            .height(145.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .clickable { onItemClick(movie.id) }
                    )
                }
            }
        }

        is DataState.Error -> {
            ErrorView(text = state.error)
        }

        is DataState.Loading -> {
            Loading()
        }
    }
}