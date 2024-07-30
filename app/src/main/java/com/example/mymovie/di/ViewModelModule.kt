package com.example.mymovie.di

import com.example.mymovie.presentation.screens.detail.DetailViewModel
import com.example.mymovie.presentation.screens.home.HomeViewModel
import com.example.mymovie.presentation.screens.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::DetailViewModel)
    viewModelOf(::SearchViewModel)
}