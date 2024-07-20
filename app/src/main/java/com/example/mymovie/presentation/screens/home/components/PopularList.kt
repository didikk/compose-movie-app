package com.example.mymovie.presentation.screens.home.components

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mymovie.domain.model.Movie
import com.example.mymovie.presentation.base.DataState

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun PopularList(
    onItemClick: (Int) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    state: DataState<List<Movie>> = DataState.Loading
) {
    when (state) {
        is DataState.Loading -> {
            Box(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        is DataState.Success -> {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                contentPadding = PaddingValues(horizontal = 24.dp),
                modifier = Modifier.padding(top = 20.dp)
            ) {
                itemsIndexed(state.data) { index, movie ->
                    PopularItem(
                        index,
                        movie,
                        onItemClick,
                        sharedTransitionScope,
                        animatedContentScope
                    )
                }
            }
        }

        is DataState.Error -> {
            Box(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = state.error,
                    modifier = Modifier.align(Alignment.Center),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun PopularItem(
    index: Int,
    data: Movie,
    onItemClick: (Int) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    Box(modifier = Modifier.clickable { onItemClick(index) }) {
        with(sharedTransitionScope) {
            AsyncImage(
                model = data.getPosterUrl(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(144.dp)
                    .height(210.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .sharedElement(
                        sharedTransitionScope.rememberSharedContentState(key = "image-popular-${data.id}"),
                        animatedVisibilityScope = animatedContentScope
                    )
            )
        }
        Text(
            text = "${index + 1}",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 96.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(y = 36.dp, x = -12.dp)
                .padding(bottom = 0.dp),
            style = TextStyle.Default.copy(
                drawStyle = Stroke(
                    miter = 10f,
                    width = 5f,
                    join = StrokeJoin.Round
                )
            )
        )
    }
}