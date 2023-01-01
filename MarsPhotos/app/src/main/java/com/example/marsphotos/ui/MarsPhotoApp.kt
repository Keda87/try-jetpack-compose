package com.example.marsphotos.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marsphotos.ui.screens.HomeScreen
import com.example.marsphotos.ui.viewmodel.MarsViewModel

@Composable
fun MarsPhotoApp(
    marsViewModel: MarsViewModel,
    modifier: Modifier = Modifier
) {
    HomeScreen(
        marsUiState = marsViewModel.marsUiState
    )
}