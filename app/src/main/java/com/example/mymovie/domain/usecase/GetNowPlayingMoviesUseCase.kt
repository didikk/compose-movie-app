package com.example.mymovie.domain.usecase

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.repository.MovieRepository

class GetNowPlayingMoviesUseCase(private val movieRepository: MovieRepository) :
    BaseUseCase<Any, List<Movie>> {
    override suspend fun execute(params: Any?): List<Movie> {
        return movieRepository.getNowPlayingMovies().subList(0, 5)
    }
}