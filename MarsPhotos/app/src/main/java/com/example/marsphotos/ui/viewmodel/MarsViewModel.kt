package com.example.marsphotos.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.marsphotos.MarsPhotoApplication
import com.example.marsphotos.data.model.MarsPhoto
import com.example.marsphotos.data.repository.MarsPhotoRepository
import kotlinx.coroutines.launch
import java.io.IOException


sealed interface MarsUiState {
    data class Success(val photos: List<MarsPhoto>) : MarsUiState
    object Error : MarsUiState
    object Loading : MarsUiState
}

class MarsViewModel(private val marsPhotoRepository: MarsPhotoRepository) : ViewModel() {

    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
        private set

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            marsUiState = try {
                val results = marsPhotoRepository.getMarsPhotos()
                MarsUiState.Success(results)
            } catch (e: IOException) {
                Log.e("MARS_API", e.toString())
                MarsUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val app = (this[APPLICATION_KEY] as MarsPhotoApplication)
                val marsPhotoRepository = app.container.marsPhotoRepository

                MarsViewModel(marsPhotoRepository = marsPhotoRepository)
            }
        }
    }
}
