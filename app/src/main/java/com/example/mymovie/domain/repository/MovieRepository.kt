package com.example.mymovie.domain.repository

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.model.detail.MovieDetail

interface MovieRepository {
    suspend fun getPopularMovies(): List<Movie>

    suspend fun getTopRatedMovies(): List<Movie>

    suspend fun getUpcomingMovies(): List<Movie>

    suspend fun getNowPlayingMovies(): List<Movie>

    suspend fun getMovieDetails(movieId: Int): MovieDetail

    suspend fun searchMovies(query: String): List<Movie>
}