package com.example.mymovie.presentation.screens.detail

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.mymovie.presentation.components.Header
import com.example.mymovie.presentation.screens.detail.components.Backdrop
import com.example.mymovie.presentation.screens.detail.components.DetailMenu
import com.example.mymovie.presentation.screens.detail.components.Info
import com.example.mymovie.presentation.screens.detail.components.Title

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DetailScreen(
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    id: Int
) {
    Column {
        Header(title = "Detail")
        Backdrop()
        Title(sharedTransitionScope, animatedContentScope, id)
        Info()
        DetailMenu()
    }
}