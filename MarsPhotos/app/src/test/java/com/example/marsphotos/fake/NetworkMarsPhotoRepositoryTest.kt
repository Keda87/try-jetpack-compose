package com.example.marsphotos.fake

import com.example.marsphotos.data.repository.DefaultMarsPhotoRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkMarsPhotoRepositoryTest {

    @Test
    fun networkMarsPhotoRepository_getMarsPhoto_verifyPhotoList() {
        val repo = DefaultMarsPhotoRepository(marsApiService = FakeMarsApiService())

        runTest {
            assertEquals(FakeDataSource.photosList, repo.getMarsPhotos())
        }
    }

}