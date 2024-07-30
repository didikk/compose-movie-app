package com.example.mymovie.domain.usecase

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.repository.MovieRepository

class SearchMovieUseCase(private val movieRepository: MovieRepository) :
    BaseUseCase<String, List<Movie>> {
    override suspend fun execute(params: String?): List<Movie> {
        params?.let {
            return movieRepository.searchMovies(params)
        } ?: throw IllegalArgumentException("Search query cannot be null")
    }
}