package com.example.cityapp.navigation

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cityapp.ApplicationViewModelProvider
import com.example.cityapp.components.CityAppTopAppBar
import com.example.cityapp.navigation.routes.Screen
import com.example.cityapp.presentation.GoogleAuthUiClient
import com.example.cityapp.ui.theme.screens.HomeScreenLayout
import com.example.cityapp.ui.theme.screens.signup.SignUp
import com.example.cityapp.ui.theme.signin.SignInScreen
import com.example.cityapp.ui.theme.signin.SignInViewModel
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppStartUpNavigation(
    navController: NavHostController,
) {

    val backStack = navController.currentBackStackEntryAsState()
    val applicationContext = LocalContext.current.applicationContext

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
                val state by viewModel.state.collectAsStateWithLifecycle()
                val scope = rememberCoroutineScope()


                LaunchedEffect(key1 = Unit) {
                    if( viewModel.googleAuthUiClient.getSignedInUser() != null) {
                        navController.navigate( Screen.HomeScreenLayout.route)
                    }
                }



                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.StartIntentSenderForResult(),
                    onResult = { result ->
                        if(result.resultCode == ComponentActivity.RESULT_OK) {
                            scope.launch {
                                val signInResult =  viewModel.googleAuthUiClient.signInWithIntent(
                                    intent = result.data ?: return@launch
                                )
                                viewModel.onSignInResult(signInResult)
                            }
                        }
                    }
                )

                LaunchedEffect(key1 = state.isSignInSuccessful) {
                    if(state.isSignInSuccessful) {
                        Toast.makeText(
                            applicationContext,
                            "Sign in successful",
                            Toast.LENGTH_LONG
                        ).show()

                        navController.navigate(Screen.HomeScreenLayout.route)
                        viewModel.resetState()
                    }
                }

                SignInScreen(
                    state = state,
                    onSignInClick = {
                        GlobalScope.launch {
                            val signInIntentSender =  viewModel.googleAuthUiClient.signIn()
                            launcher.launch(
                                IntentSenderRequest.Builder(
                                    signInIntentSender ?: return@launch
                                ).build()
                            )
                        }
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



}