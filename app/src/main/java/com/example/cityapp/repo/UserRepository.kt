package com.example.cityapp.repo

import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.util.Log
import com.example.cityapp.common.Resource
import com.example.cityapp.data.GoogleAuthUiService
import com.example.cityapp.domain.SignInResult
import com.example.cityapp.domain.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

interface UserRepository {
    suspend fun initiateGoogleSignIn(): IntentSender?
    suspend fun loginWithGoogle(intent: Intent): Resource<SignInResult>
    val currentUser: Flow<UserData?>
}

class UserRepositoryImpl(
    context: Context,
    val googleAuthUiService: GoogleAuthUiService,
) : UserRepository {

    private val _currentUser: MutableStateFlow<UserData?> = MutableStateFlow(null)
    override val currentUser = _currentUser.asStateFlow()

    init {
        Log.d("GOOGLDEBUG", "UserRepositoryImpl")
        loadCurrentUser()
    }

    override suspend fun loginWithGoogle(intent: Intent): Resource<SignInResult> {
        val googleData = googleAuthUiService.signInWithIntent(intent = intent)
        return if (googleData.data != null) {
            Resource.Success(data = googleData)
        } else {
            Resource.Error(data = googleData, uiText = googleData.errorMessage)
        }
    }

    private fun loadCurrentUser() {
        //Checks to see if we are logged into Google
        val user = googleAuthUiService.getSignedInUser()
        Log.d("GOOGLDEBUG", "in loadCurrentUSer")

//        _currentUser.update {
//            user
//        }
//        Log.d("GOOGLDEBUG", "in UpdatedUser ${user?.username ?: "Unknown"}")
        //Check to see if we have it stored in shared preferences.

        //if we have something we set userData and the viewModel will automatically update
    }

    override suspend fun initiateGoogleSignIn(): IntentSender? = googleAuthUiService.signIn()
}