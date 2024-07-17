package com.example.mymovie.presentation.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
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

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: Routes = Routes.MainGraph
) {
    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier
        ) {
            navigation<Routes.MainGraph>(startDestination = Routes.Home) {
                composable<Routes.Home> {
                    HomeScreen(
                        toDetail = { index ->
                            navController.navigate(Routes.Detail(index))
                        }, toSearch = {
                            navController.navigate(Routes.Search)
                        },
                        sharedTransitionScope = this@SharedTransitionLayout,
                        animatedContentScope = this@composable
                    )
                }
                composable<Routes.Search> {
                    SearchScreen()
                }
                composable<Routes.Favorite> {
                    FavoriteScreen()
                }
            }
            composable<Routes.Detail> { backStackEntry ->
                val detail: Routes.Detail = backStackEntry.toRoute()
                DetailScreen(
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedContentScope = this@composable,
                    id = detail.id
                )
            }
        }
    }
}