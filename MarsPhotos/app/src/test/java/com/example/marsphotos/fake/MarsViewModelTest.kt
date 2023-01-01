package com.example.marsphotos.fake

import com.example.marsphotos.rules.TestDispatcherRule
import com.example.marsphotos.ui.viewmodel.MarsUiState
import com.example.marsphotos.ui.viewmodel.MarsViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class MarsViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() {
        runTest {
            val marsViewModel = MarsViewModel(marsPhotoRepository = FakeMarsPhotoRepository())

            assertEquals(MarsUiState.Success(photos = FakeDataSource.photosList), marsViewModel.marsUiState)
        }
    }
}