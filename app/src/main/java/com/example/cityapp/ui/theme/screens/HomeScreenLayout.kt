package com.example.cityapp.ui.theme.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cityapp.navigation.bottomNavigation.CustomButtomNavigation
import com.example.cityapp.navigation.routes.Screen.HomeScreens.*
import com.example.cityapp.navigation.routes.ScreenArgs
import com.example.cityapp.ui.theme.screens.bookmark.BookmarkScreen
import com.example.cityapp.ui.theme.screens.catalog.CatalogScreen
import com.example.cityapp.ui.theme.screens.home.HomeScreen
import com.example.cityapp.ui.theme.screens.listViewScreen.ListViewScreen

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
                HomeScreen(
                    onNavigateToListScreen = { id ->
                        //TodoNavigateToList
                        navController.navigate(
                            route = ListViewRoute.route.replace(
                                ScreenArgs.SEARCH_ID.name,
                                id.title.name
                            )
                        )
                    }
                )
            }

            composable(BookMarkRoute.route){
                BookmarkScreen()
            }

            composable(CatalogRoute.route){
                CatalogScreen()
            }

            composable(
                route = ListViewRoute.route,
                arguments = listOf(navArgument(ScreenArgs.SEARCH_ID.name){type = NavType.StringType})
            ){ backStackEntry ->
                val id =  backStackEntry.arguments?.getString(ScreenArgs.SEARCH_ID.name)?: "unknown"
                ListViewScreen(
                    id = id,
                )
            }
        }
    }
}
