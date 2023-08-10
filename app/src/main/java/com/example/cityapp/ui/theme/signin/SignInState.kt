package com.example.cityapp.ui.theme.signin

data class SignInState(
    val googleSignState: GoogleSignInState = GoogleSignInState(),
    val manualSignInState: ManualSignInState = ManualSignInState(),
    val signInError: Boolean = false,
)

sealed class LoginStates{
    object Loading: LoginStates()
    data class Error(val reason: String): LoginStates()
    data class LoginInProgress(val username: String = "", val password: String = ""): LoginStates(){
        val u = mutableSetOf<String>("")
    }
    data class SuccessfulLogin(val usernameId: String): LoginStates()
}




data class GoogleSignInState(val isSignInSuccessful: Boolean = false)
data class ManualSignInState(val username: String = "", val password: String = "")