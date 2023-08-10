package com.example.cityapp.data

import android.content.Context
import android.content.Intent
import android.content.IntentSender
import com.example.cityapp.domain.SignInResult
import com.example.cityapp.domain.UserData
import com.google.android.gms.auth.api.identity.SignInClient

interface GoogleAuthUiService{
    suspend fun signIn(): IntentSender?
    suspend fun signInWithIntent(intent: Intent): SignInResult
    suspend fun signOut()
    fun getSignedInUser(): UserData?
}

class GoogleAuthUiServiceImpl(
    private val context: Context,
    private val oneTapClient: SignInClient,
) : GoogleAuthUiService {

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = context,
            oneTapClient = oneTapClient
        )
    }

    override suspend fun signIn(): IntentSender? = googleAuthUiClient.signIn()
    override suspend fun signInWithIntent(intent: Intent): SignInResult = googleAuthUiClient.signInWithIntent(intent)
    override suspend fun signOut() = googleAuthUiClient.signOut()
    override fun getSignedInUser(): UserData? = googleAuthUiClient.getSignedInUser()

}