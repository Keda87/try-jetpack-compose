package com.example.marsphotos.data.network

import com.example.marsphotos.data.model.MarsPhoto
import retrofit2.http.GET


interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}