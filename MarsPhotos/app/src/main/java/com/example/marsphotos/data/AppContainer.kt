package com.example.marsphotos.data

import com.example.marsphotos.data.network.MarsApiService
import com.example.marsphotos.data.repository.DefaultMarsPhotoRepository
import com.example.marsphotos.data.repository.MarsPhotoRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val marsPhotoRepository: MarsPhotoRepository
}

@OptIn(ExperimentalSerializationApi::class)
class DefaultAppContainer : AppContainer {

    private val baseURL = "https://android-kotlin-fun-mars-server.appspot.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseURL)
        .build()

    private val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

    override val marsPhotoRepository: MarsPhotoRepository by lazy {
        DefaultMarsPhotoRepository(retrofitService)
    }

}