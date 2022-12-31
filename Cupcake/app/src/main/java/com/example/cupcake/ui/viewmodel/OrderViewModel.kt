package com.example.cupcake.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cupcake.ui.state.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

private const val PRICE_PER_CUPCAKE = 2.00
private const val PRICE_FOR_SAME_DAY_PICKUP = 3.00

class OrderViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(OrderUiState(pickUpOptions = pickUpOptions()))
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    fun setOrderQuantity(qty: Int) {
        _uiState.update {
            it.copy(
                quantity = qty,
                price = calculatePrice(qty = qty, pickUpDate = it.pickupDate)
            )
        }
    }

    fun setPickUpDate(userPick: String) {
        _uiState.update {
            it.copy(
                pickupDate = userPick,
                price = calculatePrice(qty = it.quantity, pickUpDate = userPick)
            )
        }
    }

    fun setFlavor(userPick: String) {
        _uiState.update {
            it.copy(flavor = userPick)
        }
    }

    fun resetOrder() {
        _uiState.value = OrderUiState(pickUpOptions = pickUpOptions())
    }

    private fun calculatePrice(qty: Int, pickUpDate: String): String {
        var result = qty * PRICE_PER_CUPCAKE

        if (pickUpDate == pickUpOptions()[0]) {
            result += PRICE_FOR_SAME_DAY_PICKUP
        }

        return NumberFormat.getCurrencyInstance().format(result)
    }

    private fun pickUpOptions(): List<String> {
        val dateOptions = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()

        repeat(4) {
            dateOptions.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }

        return dateOptions
    }
}