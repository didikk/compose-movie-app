package com.example.mymovie.data.repository

import com.example.mymovie.data.network.service.MovieService
import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.model.detail.MovieDetail
import com.example.mymovie.domain.repository.MovieRepository

class MovieRepositoryImpl(private val movieService: MovieService) : MovieRepository {
    override suspend fun getPopularMovies(): List<Movie> {
        return movieService.getPopularMovies().results
    }

    override suspend fun getTopRatedMovies(): List<Movie> {
        return movieService.getTopRatedMovies().results
    }

    override suspend fun getUpcomingMovies(): List<Movie> {
        return movieService.getUpcomingMovies().results
    }

    override suspend fun getNowPlayingMovies(): List<Movie> {
        return movieService.getNowPlayingMovies().results
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetail {
        return movieService.getMovieDetails(movieId)
    }

    override suspend fun searchMovies(query: String): List<Movie> {
        return movieService.searchMovies(query).results
    }
}