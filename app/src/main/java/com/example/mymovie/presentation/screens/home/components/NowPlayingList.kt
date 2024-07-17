package com.example.mymovie.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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

@Composable
fun NowPlayingList(modifier: Modifier = Modifier) {
    Text(
        text = "Now Playing",
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
            .padding(bottom = 16.dp)
            .padding(horizontal = 24.dp)
    )
    LazyRow(
        contentPadding = PaddingValues(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(5) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w400/1E5baAaEse26fej7uHcjOgEE2t2.jpg",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(100.dp)
                    .height(145.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }
    }
}