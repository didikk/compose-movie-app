package com.example.mymovie.domain.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity("favorite")
@Serializable
data class Movie(
    val adult: Boolean,

    @ColumnInfo("backdrop_path")
    @SerialName("backdrop_path")
    val backdropPath: String?,

    @ColumnInfo("genre_ids")
    @SerialName("genre_ids")
    val genreIds: List<Int>,

    @PrimaryKey
    val id: Int,

    @ColumnInfo("original_language")
    @SerialName("original_language")
    val originalLanguage: String,

    @ColumnInfo("original_title")
    @SerialName("original_title")
    val originalTitle: String,

    val overview: String,
    val popularity: Double,

    @ColumnInfo("poster_path")
    @SerialName("poster_path")
    val posterPath: String?,

    @ColumnInfo("release_date")
    @SerialName("release_date")
    val releaseDate: String,

    val title: String,
    val video: Boolean,

    @ColumnInfo("vote_average")
    @SerialName("vote_average")
    val voteAverage: Double,

    @ColumnInfo("vote_count")
    @SerialName("vote_count")
    val voteCount: Int
) {
    fun getPosterUrl() = "$BASE_URL_IMAGE$posterPath"
}