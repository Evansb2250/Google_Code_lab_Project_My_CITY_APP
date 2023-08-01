package com.example.cityapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val _loading = MutableStateFlow(true)
    val loading = _loading.asStateFlow()


    init {
        viewModelScope.launch {
            delay(3000)
            _loading.value = false
        }
    }
}