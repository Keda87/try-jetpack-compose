package com.example.marsphotos.fake

import com.example.marsphotos.data.model.MarsPhoto
import com.example.marsphotos.data.network.MarsApiService

class FakeMarsApiService : MarsApiService{

    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }

}