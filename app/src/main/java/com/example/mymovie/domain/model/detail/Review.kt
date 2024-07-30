package com.example.mymovie.domain.model.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Review(
    val author: String,
    @SerialName("author_details")
    val authorDetails: AuthorDetails,
    val content: String,
    @SerialName("created_at")
    val createdAt: String,
    val id: String,
    @SerialName("updated_at")
    val updatedAt: String,
    val url: String
)