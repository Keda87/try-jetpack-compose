package id.web.adiyatmubarak.inventory.ui


import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import id.web.adiyatmubarak.inventory.InventoryApplication
import id.web.adiyatmubarak.inventory.ui.screen.CreateItemViewModel
import id.web.adiyatmubarak.inventory.ui.screen.HomeViewModel

object AppViewModelProvider {

    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(inventoryApplication().container.itemRepository)
        }

        initializer {
            CreateItemViewModel(inventoryApplication().container.itemRepository)
        }
    }
}

fun CreationExtras.inventoryApplication(): InventoryApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)