package com.app.compose.cricket.ui.bottomnavigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.app.compose.cricket.ui.compose.IconRes

private val navigationItem: List<NavigationItem> = NavigationItem.values().toList()

@Composable
fun NavigationBar(navController: NavHostController) = BottomNavigation(
    backgroundColor = Color.Black,
    contentColor = Color.White
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    navigationItem.forEach { item ->
        BottomNavigationItem(
            icon = { IconRes(icon = item.icon) },
            label = { Text(text = stringResource(id = item.title)) },
            selected = currentRoute == item.route,
            selectedContentColor = Color.White,
            unselectedContentColor = Color.White.copy(alpha = 0.4f),
            alwaysShowLabel = true,
            onClick = {
                navController.navigate(item.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            }
        )
    }
}