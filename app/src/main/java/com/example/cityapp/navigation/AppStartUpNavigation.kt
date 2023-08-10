package com.example.cityapp.navigation

import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cityapp.ApplicationViewModelProvider
import com.example.cityapp.components.CityAppTopAppBar
import com.example.cityapp.navigation.routes.Screen
import com.example.cityapp.ui.theme.screens.HomeScreenLayout
import com.example.cityapp.ui.theme.screens.login.LoginScreen
import com.example.cityapp.ui.theme.screens.signup.SignUp
import com.example.cityapp.ui.theme.signin.SignInMethod
import com.example.cityapp.ui.theme.signin.SignInViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppStartUpNavigation(
    navController: NavHostController,
) {

    val backStack = navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            val destination = backStack.value?.destination?.route ?: Screen.Login.route
            if (destination != Screen.Login.route && destination != Screen.SignUp.route) {
                CityAppTopAppBar()
            }
        },
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(
                route = Screen.Login.route,
            ) {

                val viewModel = viewModel<SignInViewModel>(factory = ApplicationViewModelProvider.Factor)
                val scope = rememberCoroutineScope()


                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.StartIntentSenderForResult(),
                    onResult = { result ->
                        if (result.resultCode == ComponentActivity.RESULT_OK) {
                            scope.launch {
                                viewModel.signInGoogleWithIntent(
                                    intent = result.data ?: return@launch
                                )
                            }
                        }
                    }
                )


                LoginScreen(
                    state = viewModel.state.collectAsState().value,
                    navToSignUpPage = {
                        navController.navigate(
                            Screen.SignUp.route
                        )
                    },
                    navToHomePage = {
                        navController.navigate(
                            Screen.HomeScreenLayout.route
                        )
                    },
                    signIn = { method ->
                        when (method) {
                            SignInMethod.GoogleSignIn -> {
                                scope.launch {
                                    val signInIntentSender = viewModel.signInWithGoogle()
                                    launcher.launch(
                                        IntentSenderRequest.Builder(
                                            signInIntentSender ?: return@launch
                                        ).build()
                                    )
                                }
                            }

                            SignInMethod.LocalSignIn -> {

                            }
                        }
                    },
                    updateUser = viewModel::updateUserCredentials,
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
}