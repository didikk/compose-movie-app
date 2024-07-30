package com.example.mymovie.presentation.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
    viewModel: DetailViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getMovieDetail(id)
    }

    Column {
        Header(title = "Detail")

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