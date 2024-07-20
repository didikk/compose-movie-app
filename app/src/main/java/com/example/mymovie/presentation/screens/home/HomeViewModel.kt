package com.example.mymovie.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.usecase.GetPopularMoviesUseCase
import com.example.mymovie.presentation.base.DataState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val getPopularMoviesUseCase: GetPopularMoviesUseCase) : ViewModel() {
    private val _popularState = MutableStateFlow<DataState<List<Movie>>>(DataState.Loading)
    val popularState: StateFlow<DataState<List<Movie>>> = _popularState

    init {
        getPopularMovies()
    }

    fun getPopularMovies() {
        viewModelScope.launch {
            try {
                _popularState.value = DataState.Loading
                val popularMovies = getPopularMoviesUseCase.execute()
                _popularState.value = DataState.Success(popularMovies)
            } catch (e: Exception) {
                _popularState.value = DataState.Error(e.message.toString())
            }
        }
    }

}