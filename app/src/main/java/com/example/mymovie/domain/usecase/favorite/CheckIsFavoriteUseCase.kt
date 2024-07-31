package com.example.mymovie.domain.usecase.favorite

import com.example.mymovie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class CheckIsFavoriteUseCase(private val movieRepository: MovieRepository) {
    fun execute(movieId: Int): Flow<Boolean> {
        return movieRepository.isFavorite(movieId)
    }
}