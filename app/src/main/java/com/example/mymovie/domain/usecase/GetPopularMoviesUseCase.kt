package com.example.mymovie.domain.usecase

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.repository.MovieRepository

class GetPopularMoviesUseCase(private val movieRepository: MovieRepository) :
    BaseUseCase<Any, List<Movie>> {
    override suspend fun execute(params: Any?): List<Movie> {
        return movieRepository.getPopularMovies().subList(0, 5)
    }
}