package com.example.mymovie.di

import com.example.mymovie.data.repository.MovieRepositoryImpl
import com.example.mymovie.domain.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
}