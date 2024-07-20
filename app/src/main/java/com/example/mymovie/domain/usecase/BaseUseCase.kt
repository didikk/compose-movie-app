package com.example.mymovie.domain.usecase

interface BaseUseCase<in PARAM, out OUTPUT> {
    suspend fun execute(params: PARAM? = null): OUTPUT
}