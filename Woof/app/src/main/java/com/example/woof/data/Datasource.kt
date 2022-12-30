package com.example.woof.data

import com.example.woof.R
import com.example.woof.model.Dog

object Datasource {

    fun loadDogs(): List<Dog> {
        return listOf(
            Dog(R.drawable.dog1_bella, R.string.dog_name_1, 12, R.string.dog_description_1),
            Dog(R.drawable.dog2_faye, R.string.dog_name_2, 18, R.string.dog_description_2),
            Dog(R.drawable.dog3_frankie, R.string.dog_name_3, 3, R.string.dog_description_3),
            Dog(R.drawable.dog4_koda, R.string.dog_name_4, 11, R.string.dog_description_4),
            Dog(R.drawable.dog5_leroy, R.string.dog_name_5, 21, R.string.dog_description_5),
            Dog(R.drawable.dog6_lola, R.string.dog_name_6, 7, R.string.dog_description_6),
            Dog(R.drawable.dog7_moana, R.string.dog_name_7, 3, R.string.dog_description_7),
            Dog(R.drawable.dog8_nox, R.string.dog_name_8, 9, R.string.dog_description_8),
            Dog(R.drawable.dog9_tzeitel, R.string.dog_name_9, 11, R.string.dog_description_9),
        )
    }
}