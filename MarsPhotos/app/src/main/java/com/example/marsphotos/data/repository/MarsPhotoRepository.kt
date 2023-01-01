package com.example.marsphotos.data.repository

import com.example.marsphotos.data.model.MarsPhoto
import com.example.marsphotos.data.network.MarsApiService

interface MarsPhotoRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

class DefaultMarsPhotoRepository(private val marsApiService: MarsApiService) : MarsPhotoRepository {

    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return marsApiService.getPhotos()
    }

}