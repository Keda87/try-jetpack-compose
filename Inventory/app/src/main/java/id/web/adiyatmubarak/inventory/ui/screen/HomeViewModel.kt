package id.web.adiyatmubarak.inventory.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.web.adiyatmubarak.inventory.data.Item
import id.web.adiyatmubarak.inventory.data.ItemRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(itemRepository: ItemRepository): ViewModel() {

    val homeUiState: StateFlow<HomeUiState> = itemRepository.getAllItemsStream().map { HomeUiState(it) }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(TIMEOUT_MILIS),
        initialValue = HomeUiState()
    )

    companion object {
        private const val TIMEOUT_MILIS = 5_000L
    }

}

data class HomeUiState(val itemList: List<Item> = listOf())