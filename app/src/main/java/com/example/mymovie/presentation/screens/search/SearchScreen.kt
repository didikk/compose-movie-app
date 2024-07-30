package com.example.mymovie.presentation.screens.search

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mymovie.domain.model.Movie
import com.example.mymovie.presentation.base.DataState
import com.example.mymovie.presentation.components.ErrorView
import com.example.mymovie.presentation.components.Header
import com.example.mymovie.presentation.components.Loading
import com.example.mymovie.presentation.components.MovieItem
import com.example.mymovie.presentation.components.SearchBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(toDetail: (Int) -> Unit, viewModel: SearchViewModel = koinViewModel()) {

    val query by viewModel.inputText.collectAsState()
    val state by viewModel.resultState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.initialize()
    }

    Column {
        Header(title = "Search")
        SearchBar(
            modifier = Modifier.padding(24.dp),
            value = query,
            onValueChange = { viewModel.setInputText(it) })

        state.let { it ->
            when (it) {
                is DataState.Loading -> {
                    Loading()
                }

                is DataState.Success -> {
                    LazyColumn {
                        items(it.data) { result ->
                            MovieItem(
                                modifier = Modifier
                                    .padding(horizontal = 24.dp)
                                    .padding(bottom = 24.dp)
                                    .clickable { toDetail(result.id) },
                                movie = result
                            )
                        }
                    }
                }

                is DataState.Error -> {
                    ErrorView(text = it.error)
                }
            }
        }
    }
}