package com.example.cityapp.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cityapp.components.CityAppTopAppBar
import com.example.cityapp.navigation.AppStartUpNavigation
import com.example.cityapp.navigation.routes.Screen

val sidePadding = 16.dp

@Preview(
    showBackground = true
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun onAppStartUP() {
    val navController = rememberNavController()
    val backStack = navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            val destination = backStack.value?.destination?.route ?: Screen.Login.route
            if (destination != Screen.Login.route && destination != Screen.SignUp.route) {
                CityAppTopAppBar()
            }
        },
    ) { innerPadding ->
        AppStartUpNavigation(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}