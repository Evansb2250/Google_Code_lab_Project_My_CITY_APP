package com.example.cityapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cityapp.navigation.routes.Screen
import com.example.cityapp.ui.theme.screens.HomeScreenLayout
import com.example.cityapp.ui.theme.screens.login.LoginScreen
import com.example.cityapp.ui.theme.screens.signup.SignUp

@Composable
fun AppStartUpNavigation(
    navController: NavHostController,
    modifier: Modifier
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        modifier = modifier,
    ) {
        composable(
            route = Screen.Login.route,
        ) {
            LoginScreen(
                navToSignUpPage = {
                    navController.navigate(
                        route = Screen.SignUp.route,
                    )
                },
                navToLoginScreen = {
                    navController.navigate(Screen.HomeScreenLayout.route)
                }
            )
        }

        composable(
            route = Screen.SignUp.route,
        ) {
            SignUp(
                navigateToLoginScreen = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screen.HomeScreenLayout.route,
        ) {
             HomeScreenLayout()
        }
    }
}