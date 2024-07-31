package com.example.mymovie.domain.usecase.favorite

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.repository.MovieRepository
import com.example.mymovie.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.last

class ToggleFavoriteUseCase(private val movieRepository: MovieRepository) :
    BaseUseCase<Movie, Unit> {
    override suspend fun execute(params: Movie?) {
        params?.let {
            if (movieRepository.isFavorite(it.id).last()) {
                movieRepository.removeFavorite(it)
            } else {
                movieRepository.addFavorite(it)
            }
        } ?: throw IllegalArgumentException("Movie cannot be null")
    }
}