package com.example.mymovie.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    object MainGraph: Routes()

    @Serializable
    object Home : Routes()

    @Serializable
    object Search : Routes()

    @Serializable
    object Favorite : Routes()

    @Serializable
    data class Detail(val id: Int) : Routes()
}