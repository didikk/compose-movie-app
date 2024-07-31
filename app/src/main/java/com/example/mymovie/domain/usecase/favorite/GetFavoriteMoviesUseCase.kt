package com.example.mymovie.domain.usecase.favorite

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteMoviesUseCase(private val movieRepository: MovieRepository) {
    fun execute(): Flow<List<Movie>> {
        return movieRepository.getFavoriteMovies()
    }
}