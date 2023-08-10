package com.example.cityapp.application

import android.content.Context
import com.example.cityapp.data.GoogleAuthUiService
import com.example.cityapp.data.GoogleAuthUiServiceImpl
import com.example.cityapp.repo.UserRepository
import com.example.cityapp.repo.UserRepositoryImpl
import com.google.android.gms.auth.api.identity.Identity

//need to create an interface
interface ApplicationContainer {
    val userRepository: UserRepository
}

class DefaultApplicationContainer(val context: Context) : ApplicationContainer {
    override val userRepository: UserRepository by lazy {
        UserRepositoryImpl(
            context,
            googleAuthUiService = GoogleAuthUiServiceImpl(
                context = context,
                oneTapClient = Identity.getSignInClient(context)
            )
        )
    }

}