package com.example.mymovie.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mymovie.presentation.theme.MidnitghtGrey
import com.example.mymovie.presentation.utils.topBorder

@Composable
fun BottomNavigation(navController: NavHostController) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    NavigationBar(
        containerColor = Color.Transparent,
        modifier = Modifier.topBorder(1.dp, MaterialTheme.colorScheme.primary)
    ) {
        tabItems.forEach() {
            NavigationBarItem(
                icon = { Icon(it.icon, contentDescription = null) },
                label = { Text(it.label) },
                selected = backStackEntry?.destination?.hasRoute(it.route::class) ?: false,
                colors = NavigationBarItemDefaults.colors().copy(
                    selectedIndicatorColor = Color.Transparent,
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MidnitghtGrey,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = MidnitghtGrey
                ),
                onClick = {
                    navController.navigate(it.route)
                }
            )
        }
    }
}

sealed class TabItem(val route: Routes, val label: String, val icon: ImageVector) {
    object Home : TabItem(Routes.Home, "Home", Icons.Outlined.Home)
    object Search : TabItem(Routes.Search, "Search", Icons.Filled.Search)
    object Favorite : TabItem(Routes.Favorite, "Favorite", Icons.Default.FavoriteBorder)
}

val tabItems = listOf(
    TabItem.Home,
    TabItem.Search,
    TabItem.Favorite
)

