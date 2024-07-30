package com.example.mymovie.domain.model.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BelongsToCollection(
    @SerialName("backdrop_path")
    val backdropPath: String?,
    val id: Int,
    val name: String,
    @SerialName("poster_path")
    val posterPath: String
)