package com.example.marsphotos.fake

import com.example.marsphotos.data.model.MarsPhoto
import com.example.marsphotos.data.repository.MarsPhotoRepository

class FakeMarsPhotoRepository : MarsPhotoRepository{

    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}