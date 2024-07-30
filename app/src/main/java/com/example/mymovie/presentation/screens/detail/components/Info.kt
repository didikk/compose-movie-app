package com.example.mymovie.presentation.screens.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mymovie.R
import com.example.mymovie.domain.model.detail.MovieDetail
import com.example.mymovie.presentation.theme.LilacFields
import com.example.mymovie.presentation.utils.formatDate

@Composable
fun Info(movieDetail: MovieDetail) {
    Row(
        modifier = Modifier
            .offset(y = -36.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Outlined.DateRange,
            contentDescription = null,
            tint = LilacFields,
            modifier = Modifier
                .padding(end = 4.dp)
                .size(16.dp)
        )
        Text(
            text = movieDetail.releaseDate.formatDate("yyyy"),
            color = LilacFields,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp
        )
        Spacer(
            Modifier
                .padding(horizontal = 12.dp)
                .height(16.dp)
                .width(1.dp)
                .background(color = LilacFields)
        )
        Icon(
            painter = painterResource(R.drawable.ic_access_time_24),
            contentDescription = null,
            tint = LilacFields,
            modifier = Modifier
                .padding(end = 4.dp)
                .size(16.dp)
        )
        Text(
            text = "${movieDetail.runtime} Minutes",
            color = LilacFields,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp
        )
        Spacer(
            Modifier
                .padding(horizontal = 12.dp)
                .height(16.dp)
                .width(1.dp)
                .background(color = LilacFields)
        )
        Icon(
            imageVector = Icons.Outlined.Info,
            contentDescription = null,
            tint = LilacFields,
            modifier = Modifier
                .padding(end = 4.dp)
                .size(16.dp)
        )
        Text(
            text = movieDetail.genres[0].name,
            color = LilacFields,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp
        )
    }
}