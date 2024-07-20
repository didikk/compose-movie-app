package com.example.mymovie.di

import com.example.mymovie.domain.usecase.GetPopularMoviesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPopularMoviesUseCase(get()) }
}