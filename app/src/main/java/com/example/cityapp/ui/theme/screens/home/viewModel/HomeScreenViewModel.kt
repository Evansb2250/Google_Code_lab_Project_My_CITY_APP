package com.example.cityapp.ui.theme.screens.home.viewModel

import androidx.lifecycle.ViewModel
import com.example.cityapp.data.DataSource
import com.example.cityapp.domain.HomeScreenHeaders
import com.example.cityapp.domain.HomeScreenUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeScreenViewModel : ViewModel() {
    private val _state = MutableStateFlow(
        HomeScreenUIState(
            title = HomeScreenHeaders.Home,
            headers = DataSource.listOfHeaders,
        )
    )

    val state: StateFlow<HomeScreenUIState> = _state.asStateFlow()

}