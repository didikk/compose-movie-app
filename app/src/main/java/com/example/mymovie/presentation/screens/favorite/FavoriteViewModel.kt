package com.example.mymovie.presentation.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovie.domain.usecase.favorite.GetFavoriteMoviesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class FavoriteViewModel(private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase) :
    ViewModel() {

    val favoriteMovies = getFavoriteMoviesUseCase.execute()
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
}