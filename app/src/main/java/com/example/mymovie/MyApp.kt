package com.example.mymovie

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mymovie.presentation.navigation.AppNavHost
import com.example.mymovie.presentation.navigation.BottomNavigation
import com.example.mymovie.presentation.navigation.Routes

@Composable
fun MyApp(navController: NavHostController) {
    val showAppBar = navController.currentBackStackEntryAsState().value?.destination?.let {
        it.hasRoute(Routes.Home::class) || it.hasRoute(Routes.Search::class) || it.hasRoute(Routes.Favorite::class)
    } ?: false

    Scaffold(bottomBar = {
        if (showAppBar) {
            BottomNavigation(navController)
        }
    }) { innerPadding ->
        AppNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}