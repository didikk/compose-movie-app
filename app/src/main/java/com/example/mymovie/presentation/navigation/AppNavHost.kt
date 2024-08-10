package com.example.mymovie.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import com.example.mymovie.presentation.screens.detail.DetailScreen
import com.example.mymovie.presentation.screens.favorite.FavoriteScreen
import com.example.mymovie.presentation.screens.home.HomeScreen
import com.example.mymovie.presentation.screens.search.SearchScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: Routes = Routes.MainGraph
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        navigation<Routes.MainGraph>(startDestination = Routes.Home) {
            composable<Routes.Home> {
                HomeScreen(
                    toDetail = { id ->
                        navController.navigate(Routes.Detail(id))
                    }, toSearch = {
                        navController.navigate(Routes.Search)
                    }
                )
            }
            composable<Routes.Search> {
                SearchScreen(
                    toDetail = { id ->
                        navController.navigate(Routes.Detail(id))
                    }
                )
            }
            composable<Routes.Favorite> {
                FavoriteScreen(
                    toDetail = { id ->
                        navController.navigate(Routes.Detail(id))
                    }
                )
            }
        }
        composable<Routes.Detail> { backStackEntry ->
            val detail: Routes.Detail = backStackEntry.toRoute()
            DetailScreen(id = detail.id, back = { navController.popBackStack() })
        }
    }
}