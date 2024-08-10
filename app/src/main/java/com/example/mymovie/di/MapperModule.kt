package com.example.mymovie.di

import com.example.mymovie.domain.mapper.MovieDetailMapper
import org.koin.dsl.module

val mapperModule = module {
    factory { MovieDetailMapper() }
}