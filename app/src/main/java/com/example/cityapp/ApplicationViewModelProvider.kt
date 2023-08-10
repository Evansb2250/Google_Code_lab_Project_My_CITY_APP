package com.example.cityapp

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.cityapp.application.CityApp
import com.example.cityapp.ui.theme.signin.SignInViewModel

object ApplicationViewModelProvider {
    val Factor = viewModelFactory {
        initializer {
            SignInViewModel(cityAppApplication().container.userRepository)
        }
    }
}

fun CreationExtras.cityAppApplication(): CityApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as CityApp)
