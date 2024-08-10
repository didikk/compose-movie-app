package com.example.mymovie.presentation.screens.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.mymovie.R
import com.example.mymovie.domain.model.detail.MovieDetail
import com.example.mymovie.presentation.base.DataState
import com.example.mymovie.presentation.components.ErrorView
import com.example.mymovie.presentation.components.Header
import com.example.mymovie.presentation.components.Loading
import com.example.mymovie.presentation.screens.detail.components.Backdrop
import com.example.mymovie.presentation.screens.detail.components.DetailMenu
import com.example.mymovie.presentation.screens.detail.components.Info
import com.example.mymovie.presentation.screens.detail.components.Title
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    id: Int,
    back: () -> Unit,
    viewModel: DetailViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    val isFavorite by viewModel.isFavorite.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getMovieDetail(id)
        viewModel.checkIsFavorite(id)
    }

    Column {
        Header(title = "Detail",
            leftIcon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_arrow_back_24),
                    contentDescription = null,
                    modifier = Modifier.clickable { back() }
                )
            }, rightIcon = {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        viewModel.toggleFavorite()
                    }
                )
            })

        state.let {
            when (it) {
                is DataState.Success -> {
                    val data = it.data

                    Backdrop(data)
                    Title(data.getPosterUrl(), data.title)
                    Info(data)
                    DetailMenu(data)
                }

                is DataState.Loading -> {
                    Loading()
                }

                is DataState.Error -> {
                    ErrorView(text = it.error)
                }
            }
        }
    }
}