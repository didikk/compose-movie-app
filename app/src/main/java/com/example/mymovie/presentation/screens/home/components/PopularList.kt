package com.example.mymovie.presentation.screens.home.components

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun PopularList(
    onItemClick: (Int) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(horizontal = 24.dp),
        modifier = Modifier.padding(top = 20.dp)
    ) {
        itemsIndexed(listOf(1, 2, 3, 4, 5)) { index, _ ->
            PopularItem(index, onItemClick, sharedTransitionScope, animatedContentScope)
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun PopularItem(
    index: Int,
    onItemClick: (Int) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    Box(modifier = Modifier.clickable { onItemClick(index) }) {
        with(sharedTransitionScope) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w400/1E5baAaEse26fej7uHcjOgEE2t2.jpg",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(144.dp)
                    .height(210.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .sharedElement(
                        sharedTransitionScope.rememberSharedContentState(key = "image-popular-$index"),
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