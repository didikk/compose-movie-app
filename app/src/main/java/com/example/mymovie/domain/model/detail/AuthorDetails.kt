package com.example.mymovie.domain.model.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthorDetails(
    @SerialName("avatar_path")
    val avatarPath: String?,
    val name: String,
    val rating: Double?,
    val username: String
)