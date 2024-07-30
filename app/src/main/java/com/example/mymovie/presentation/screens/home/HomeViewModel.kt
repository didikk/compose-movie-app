package com.example.mymovie.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.usecase.GetNowPlayingMoviesUseCase
import com.example.mymovie.domain.usecase.GetPopularMoviesUseCase
import com.example.mymovie.domain.usecase.GetTopRatedMoviesUseCase
import com.example.mymovie.domain.usecase.GetUpcomingMoviesUseCase
import com.example.mymovie.presentation.base.DataState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
) : ViewModel() {
    private val _popularState = MutableStateFlow<DataState<List<Movie>>>(DataState.Loading)
    val popularState: StateFlow<DataState<List<Movie>>> = _popularState

    private val _nowPlayingState = MutableStateFlow<DataState<List<Movie>>>(DataState.Loading)
    val nowPlayingState: StateFlow<DataState<List<Movie>>> = _nowPlayingState

    private val _topRatedState = MutableStateFlow<DataState<List<Movie>>>(DataState.Loading)
    val topRatedState: StateFlow<DataState<List<Movie>>> = _topRatedState

    private val _upcomingState = MutableStateFlow<DataState<List<Movie>>>(DataState.Loading)
    val upcomingState: StateFlow<DataState<List<Movie>>> = _upcomingState

    fun getPopularMovies() {
        viewModelScope.launch {
            try {
                val popularMovies = getPopularMoviesUseCase.execute()
                _popularState.value = DataState.Success(popularMovies)
            } catch (e: Exception) {
                _popularState.value = DataState.Error(e.message.toString())
            }
        }
    }

    fun getNowPlayingMovies() {
        viewModelScope.launch {
            try {
                val nowPlayingMovies = getNowPlayingMoviesUseCase.execute()
                _nowPlayingState.value = DataState.Success(nowPlayingMovies)
            } catch (e: Exception) {
                _nowPlayingState.value = DataState.Error(e.message.toString())
            }
        }
    }

    fun getTopRatedMovies() {
        viewModelScope.launch {
            try {
                val topRatedMovies = getTopRatedMoviesUseCase.execute()
                _topRatedState.value = DataState.Success(topRatedMovies)
            } catch (e: Exception) {
                _topRatedState.value = DataState.Error(e.message.toString())
            }
        }
    }

    fun getUpcomingMovies() {
        viewModelScope.launch {
            try {
                val upcomingMovies = getUpcomingMoviesUseCase.execute()
                _upcomingState.value = DataState.Success(upcomingMovies)
            } catch (e: Exception) {
                _upcomingState.value = DataState.Error(e.message.toString())
            }
        }
    }

}