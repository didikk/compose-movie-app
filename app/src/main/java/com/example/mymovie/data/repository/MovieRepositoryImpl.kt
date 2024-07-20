package com.example.mymovie.data.repository

import com.example.mymovie.data.network.service.MovieService
import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.repository.MovieRepository

class MovieRepositoryImpl(private val movieService: MovieService) : MovieRepository {
    override suspend fun getPopularMovies(): List<Movie> {
        return movieService.getPopularMovies().results
    }
}