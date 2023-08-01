package com.example.cityapp.ui.theme.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cityapp.domain.HomeScreenUIElements
import com.example.cityapp.ui.theme.screens.home.viewModel.HomeScreenViewModel

@Preview(
    showBackground = true
)
@Composable
fun HomeScreen(
    onNavigateToListScreen: (HomeScreenUIElements) -> Unit = {},
) {
    val vm: HomeScreenViewModel = viewModel()
    HomeScreenPage(
        state = vm.state.collectAsState().value,
        onClickTab = onNavigateToListScreen
    )
}