package com.example.mymovie.presentation.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovie.domain.model.detail.MovieDetail
import com.example.mymovie.domain.usecase.GetMovieDetailUseCase
import com.example.mymovie.presentation.base.DataState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val getMovieDetailUseCase: GetMovieDetailUseCase) : ViewModel() {
    private val _state = MutableStateFlow<DataState<MovieDetail>>(DataState.Loading)
    val state: StateFlow<DataState<MovieDetail>> = _state

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
}