package com.example.mymovie.domain.usecase

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.repository.MovieRepository

class GetTopRatedMoviesUseCase(private val movieRepository: MovieRepository) :
    BaseUseCase<Any, List<Movie>> {
    override suspend fun execute(params: Any?): List<Movie> {
        return movieRepository.getTopRatedMovies().subList(0, 5)
    }
}