package com.example.mymovie.domain.usecase.favorite

import com.example.mymovie.domain.mapper.MovieDetailMapper
import com.example.mymovie.domain.model.detail.MovieDetail
import com.example.mymovie.domain.repository.MovieRepository
import com.example.mymovie.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last

class ToggleFavoriteUseCase(
    private val movieRepository: MovieRepository,
    private val movieDetailMapper: MovieDetailMapper
) :
    BaseUseCase<MovieDetail, Unit> {
    override suspend fun execute(params: MovieDetail?) {
        params?.let {
            val movie = movieDetailMapper.map(it)
            if (movieRepository.isFavorite(it.id).first()) {
                movieRepository.removeFavorite(movie)
            } else {
                movieRepository.addFavorite(movie)
            }
        } ?: throw IllegalArgumentException("Movie cannot be null")
    }
}