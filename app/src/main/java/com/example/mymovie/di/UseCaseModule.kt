package com.example.mymovie.di

import com.example.mymovie.domain.usecase.GetMovieDetailUseCase
import com.example.mymovie.domain.usecase.GetNowPlayingMoviesUseCase
import com.example.mymovie.domain.usecase.GetPopularMoviesUseCase
import com.example.mymovie.domain.usecase.GetTopRatedMoviesUseCase
import com.example.mymovie.domain.usecase.GetUpcomingMoviesUseCase
import com.example.mymovie.domain.usecase.SearchMovieUseCase
import com.example.mymovie.domain.usecase.favorite.CheckIsFavoriteUseCase
import com.example.mymovie.domain.usecase.favorite.GetFavoriteMoviesUseCase
import com.example.mymovie.domain.usecase.favorite.ToggleFavoriteUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPopularMoviesUseCase(get()) }
    factory { GetUpcomingMoviesUseCase(get()) }
    factory { GetNowPlayingMoviesUseCase(get()) }
    factory { GetTopRatedMoviesUseCase(get()) }
    factory { GetMovieDetailUseCase(get()) }
    factory { SearchMovieUseCase(get()) }
    factory { GetFavoriteMoviesUseCase(get()) }
    factory { CheckIsFavoriteUseCase(get()) }
    factory { ToggleFavoriteUseCase(get()) }
}