package com.example.mymovie.presentation.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mymovie.presentation.components.MovieItem

fun LazyListScope.CategoryCollection(modifier: Modifier = Modifier, title: String) {
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
    items(5) {
        MovieItem(modifier = Modifier
            .padding(horizontal = 24.dp)
            .padding(bottom = 24.dp))
    }
}