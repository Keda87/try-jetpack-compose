package com.example.marsphotos.fake

import com.example.marsphotos.data.model.MarsPhoto

object FakeDataSource {

    private const val idOne = "img1"
    private const val idTwo = "img2"
    private const val imgOne = "url.1"
    private const val imgTwo = "url.2"

    val photosList = listOf(
        MarsPhoto(
            id = idOne,
            imgSrc = imgOne
        ),
        MarsPhoto(
            id = idTwo,
            imgSrc = imgTwo
        )
    )

}