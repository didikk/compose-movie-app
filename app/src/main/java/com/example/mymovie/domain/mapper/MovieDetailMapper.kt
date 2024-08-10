package com.example.mymovie.domain.mapper

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.model.detail.MovieDetail

class MovieDetailMapper : Mapper<MovieDetail, Movie> {
    override fun map(from: MovieDetail): Movie {
        with(from) {
            return Movie(
                adult = adult,
                backdropPath = backdropPath,
                genreIds = genres.map { it.id },
                id = id,
                originalLanguage = originalLanguage,
                title = title,
                voteCount = voteCount,
                originalTitle = originalTitle,
                popularity = popularity,
                posterPath = posterPath,
                releaseDate = releaseDate,
                voteAverage = voteAverage,
                video = video,
                overview = overview
            )
        }
    }
}