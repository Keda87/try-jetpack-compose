package com.example.cupcake.ui.state

data class OrderUiState(
    val quantity: Int = 0,
    val flavor: String = "",
    val pickupDate: String = "",
    val price: String = "",
    internal val pickUpOptions: List<String> = listOf()
)
