package com.example.cityapp.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cityapp.navigation.bottomNavigation.CustomButtomNavigation
import com.example.cityapp.navigation.routes.Screen.HomeScreenRoutes.*
import com.example.cityapp.screens.bookmark.BookmarkScreen
import com.example.cityapp.screens.catalog.CatalogScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenLayout() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            CustomButtomNavigation(
                navController = navController,
                items = listOf(
                    HomeScreenRoute,
                    CatalogRoute,
                    BookMarkRoute
                )
            )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = HomeScreenRoute.route,
            modifier = Modifier.padding(it)
        ) {
            composable(HomeScreenRoute.route){
                HomeScreen()
            }

            composable(BookMarkRoute.route){
                BookmarkScreen()
            }

            composable(CatalogRoute.route){
                CatalogScreen()
            }
        }
    }
}
