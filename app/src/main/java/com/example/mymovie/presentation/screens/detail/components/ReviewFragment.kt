package com.example.mymovie.presentation.screens.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mymovie.domain.model.BASE_URL_IMAGE
import com.example.mymovie.domain.model.detail.Review
import com.example.mymovie.presentation.utils.formatRating

@Composable
fun ReviewFragment(reviews: List<Review>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items(reviews) { review ->
            ReviewItem(review = review)
        }
    }
}

@Composable
private fun ReviewItem(review: Review) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AsyncImage(
                model = "$BASE_URL_IMAGE${review.authorDetails.avatarPath}",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(44.dp)
            )
            Text(
                text = review.authorDetails.rating?.formatRating() ?: "",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = review.author,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            )
            Text(
                fontSize = 12.sp,
                text = review.content
            )
        }
    }
}