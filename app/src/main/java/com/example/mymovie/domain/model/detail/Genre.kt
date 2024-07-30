package com.example.mymovie.domain.model.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    val id: Int,
    val name: String
)