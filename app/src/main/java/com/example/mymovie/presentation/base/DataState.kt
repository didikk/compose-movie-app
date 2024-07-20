package com.example.mymovie.presentation.base

sealed class DataState<out T : Any> {
    data class Success<out T : Any>(val data: T) : DataState<T>()
    data class Error(val error: String) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}