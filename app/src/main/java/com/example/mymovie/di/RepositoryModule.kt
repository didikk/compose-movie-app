package com.example.mymovie.di

import com.example.mymovie.data.repository.MovieRepositoryImpl
import com.example.mymovie.domain.repository.MovieRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::MovieRepositoryImpl) { bind<MovieRepository>() }
}