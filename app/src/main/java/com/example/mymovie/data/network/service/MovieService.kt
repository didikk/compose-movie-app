package com.example.mymovie.data.network.service

import com.example.mymovie.data.network.model.MovieResponse
import com.example.mymovie.domain.model.detail.MovieDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): MovieResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(): MovieResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(): MovieResponse

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "en-US",
        @Query("append_to_response") appendToResponse: String = "credits,reviews"
    ): MovieDetail

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String
    ): MovieResponse
}