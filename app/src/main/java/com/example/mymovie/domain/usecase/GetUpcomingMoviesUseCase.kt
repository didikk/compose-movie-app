package com.example.mymovie.domain.usecase

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.repository.MovieRepository

class GetUpcomingMoviesUseCase(private val movieRepository: MovieRepository) :
    BaseUseCase<Any, List<Movie>> {
    override suspend fun execute(params: Any?): List<Movie> {
        return movieRepository.getUpcomingMovies().subList(0, 5)
    }
}