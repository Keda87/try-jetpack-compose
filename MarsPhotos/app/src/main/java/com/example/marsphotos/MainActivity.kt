package com.example.marsphotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marsphotos.ui.MarsPhotoApp
import com.example.marsphotos.ui.theme.MarsPhotosTheme
import com.example.marsphotos.ui.viewmodel.MarsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarsPhotosTheme {
                val marsViewModel: MarsViewModel = viewModel(factory = MarsViewModel.Factory)

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MarsPhotoApp(marsViewModel = marsViewModel)
                }
            }
        }
    }
}