package com.example.mymovie.presentation.screens.detail.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mymovie.domain.model.detail.MovieDetail
import com.example.mymovie.presentation.utils.bottomBorder

private val menuList = listOf("About", "Reviews", "Cast")

@Composable
fun DetailMenu(movieDetail: MovieDetail) {
    var selectedMenu by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier.padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        menuList.forEachIndexed { index, title ->
            Text(
                text = title,
                color = if (selectedMenu == index) MaterialTheme.colorScheme.tertiary else Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                modifier = Modifier
                    .bottomBorder(
                        if (selectedMenu == index) 2.dp else 0.dp,
                        MaterialTheme.colorScheme.tertiary
                    )
                    .padding(8.dp)
                    .clickable { selectedMenu = index }
            )
        }
    }
    Box(modifier = Modifier.padding(24.dp)) {
        AnimatedContent(targetState = selectedMenu) { currentMenu ->
            when (currentMenu) {
                0 -> AboutFragment(movieDetail.overview)
                1 -> ReviewFragment(movieDetail.reviews.results)
                2 -> CastFragment(movieDetail.credits.cast)
            }
        }
    }
}