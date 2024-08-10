package com.example.mymovie.presentation.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovie.domain.model.detail.MovieDetail
import com.example.mymovie.domain.usecase.GetMovieDetailUseCase
import com.example.mymovie.domain.usecase.favorite.CheckIsFavoriteUseCase
import com.example.mymovie.domain.usecase.favorite.ToggleFavoriteUseCase
import com.example.mymovie.presentation.base.DataState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val checkIsFavoriteUseCase: CheckIsFavoriteUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<DataState<MovieDetail>>(DataState.Loading)
    val state: StateFlow<DataState<MovieDetail>> = _state

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch {
            try {
                val detail = getMovieDetailUseCase.execute(movieId)
                _state.value = DataState.Success(detail)
            } catch (e: Exception) {
                _state.value = DataState.Error(e.message.toString())
            }
        }
    }

    fun checkIsFavorite(movieId: Int) {
        viewModelScope.launch {
            checkIsFavoriteUseCase.execute(movieId).collect {
                _isFavorite.value = it
            }
        }
    }

    fun toggleFavorite() {
        _state.value.let {
            if (it is DataState.Success) {
                viewModelScope.launch {
                    toggleFavoriteUseCase.execute(it.data)
                }
            }
        }
    }
}