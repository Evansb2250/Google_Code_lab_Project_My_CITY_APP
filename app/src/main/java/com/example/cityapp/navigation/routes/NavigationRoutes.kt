package com.example.cityapp.navigation.routes

sealed class NavigationRoutes(val route: String) {
    object Home : NavigationRoutes("Home")
    object Login : NavigationRoutes("Login")
    object SignUp : NavigationRoutes("SignUp")
}
