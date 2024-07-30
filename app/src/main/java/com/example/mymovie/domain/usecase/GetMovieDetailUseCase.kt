package com.example.mymovie.domain.usecase

import com.example.mymovie.domain.model.detail.MovieDetail
import com.example.mymovie.domain.repository.MovieRepository

class GetMovieDetailUseCase(private val movieRepository: MovieRepository) :
    BaseUseCase<Int, MovieDetail> {
    override suspend fun execute(params: Int?): MovieDetail {
        params?.let {
            return movieRepository.getMovieDetails(it)
        } ?: throw IllegalArgumentException("Params can`t be null")
    }
}