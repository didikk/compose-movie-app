package com.example.mymovie.di

import com.example.mymovie.data.network.service.MovieService
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { createAuthInterceptor() }
    single { createOkHttpClient(get()) }
    single { createRetrofit(get()) }
    single { createMovieService(get()) }
}

private fun createAuthInterceptor(): Interceptor {
    val TMDB_API_KEY = "TMDB_API_KEY"

    return Interceptor { chain ->
        val original = chain.request()

        val request = original.newBuilder().header("Authorization", "Bearer $TMDB_API_KEY").build()

        chain.proceed(request)
    }
}

private fun createOkHttpClient(authInterceptor: Interceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .writeTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
}

private fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val baseUrl = "https://api.themoviedb.org/3/"

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()
}

private fun createMovieService(retrofit: Retrofit): MovieService {
    return retrofit.create(MovieService::class.java)
}