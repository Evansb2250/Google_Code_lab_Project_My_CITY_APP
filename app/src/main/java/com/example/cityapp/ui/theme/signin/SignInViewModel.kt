package com.example.cityapp.ui.theme.signin

import android.content.Intent
import android.content.IntentSender
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cityapp.common.Resource
import com.example.cityapp.repo.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel(
    val userRepository: UserRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<LoginStates> = MutableStateFlow(LoginStates.Loading)
    val state = _state.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("GOOGLDEBUG", "in loadData")

            userRepository.currentUser.collect { userData ->
                if (userData != null) {
                    Log.d("GOOGLDEBUG", "Success")
                    _state.update {
                        LoginStates.SuccessfulLogin(userData.userId)
                    }
                } else {
                    Log.d("GOOGLDEBUG", "Failed")
                    _state.update {
                        LoginStates.LoginInProgress(
                            username = "",
                            password = ""
                        )
                    }
                }
            }
        }
    }

    fun updateUserCredentials(credentialUpdate: LoginStates.LoginInProgress) {
        _state.update {
            credentialUpdate
        }
    }

    suspend fun signInWithGoogle(): IntentSender? = userRepository.initiateGoogleSignIn()
    fun signIn(signInMethod: SignInMethod) {
        when (signInMethod) {
            SignInMethod.GoogleSignIn -> {

            }

            SignInMethod.LocalSignIn -> {

            }
        }
    }

    suspend fun signInGoogleWithIntent(intent: Intent) = viewModelScope.launch {
        val  googleResponse = userRepository.loginWithGoogle(intent)
        when (googleResponse) {
            is Resource.Error -> {
                Log.d("GOOGLDEBUG", "signInGoogleWithIntent Error")
                _state.update {
                    LoginStates.Error("Failed to Login")
                }
            }
            is Resource.Success -> {
                Log.d("GOOGLDEBUG", "signInGoogleWithIntent Success")
                _state.update {
                    LoginStates.SuccessfulLogin(googleResponse.data?.data?.userId ?: "unknown")
                }
            }
        }
    }
}

sealed class SignInMethod {
    object GoogleSignIn : SignInMethod()
    object LocalSignIn : SignInMethod()
}