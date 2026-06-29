package com.github.bgrebennikovv.springmedia.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.bgrebennikovv.springmedia.navigation.*
import com.github.bgrebennikovv.springmedia.ui.components.CreateContentButton

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navigationItems = listOf(Home, Shorts, CreateContent, Subscriptions, Profile)

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                navigationItems.forEach { destination ->
                    val isSelected = currentDestination?.hierarchy?.any {
                        it.hasRoute(destination::class)
                    } == true

                    val label = destination.labelText
                    val iconVector = ImageVector.vectorResource(destination.iconResId)

                    val onNavigateClick = {
                        navController.navigate(destination) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }

                    if (destination is CreateContent) {
                        CreateContentButton(
                            icon = iconVector,
                            onClick = onNavigateClick
                        )
                    } else {
                        NavigationBarItem(
                            icon = { Icon(iconVector, contentDescription = label) },
                            label = if (label.isNotEmpty()) { { Text(label, maxLines = 1) } } else null, // Запрещаем перенос на 2 строки
                            selected = isSelected,
                            alwaysShowLabel = true,
                            onClick = onNavigateClick
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable<Home> { HomeScreen() }
            composable<Shorts> { ShortsScreen() }
            composable<CreateContent> { CreatePostScreen() }
            composable<Subscriptions> { SubscriptionsScreen() }
            composable<Profile> { ProfileScreen() }
        }
    }
}