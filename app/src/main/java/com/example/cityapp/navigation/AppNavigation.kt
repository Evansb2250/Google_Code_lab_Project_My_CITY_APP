package com.example.cityapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cityapp.navigation.routes.NavigationRoutes
import com.example.cityapp.screens.login.LoginScreen

@Composable
fun AppNavigation(
     navController: NavHostController,
     modifier: Modifier
    ) {

    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.Login.route,
        modifier = modifier,
    ){

        composable(
            route = NavigationRoutes.Login.route,
        ){
            LoginScreen()
        }

        composable(
            route = NavigationRoutes.SignUp.route,
        ){
            LoginScreen()
        }

        composable(
            route = NavigationRoutes.Home.route,
        ){
            LoginScreen()
        }
    }
}