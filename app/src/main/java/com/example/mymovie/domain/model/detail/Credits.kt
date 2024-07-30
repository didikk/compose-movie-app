package com.example.mymovie.domain.model.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Credits(
    val cast: List<Cast>,
    val crew: List<Crew>
)