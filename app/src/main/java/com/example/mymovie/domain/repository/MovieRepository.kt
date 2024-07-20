package com.example.mymovie.domain.repository

import com.example.mymovie.domain.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): List<Movie>
}