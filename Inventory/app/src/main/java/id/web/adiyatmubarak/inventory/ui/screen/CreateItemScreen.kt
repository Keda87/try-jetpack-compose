package id.web.adiyatmubarak.inventory.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import id.web.adiyatmubarak.inventory.InventoryTopAppBar
import id.web.adiyatmubarak.inventory.R
import id.web.adiyatmubarak.inventory.ui.AppViewModelProvider
import id.web.adiyatmubarak.inventory.ui.navigation.NavigationDestination
import kotlinx.coroutines.launch
import java.util.*

object CreateItemDestination : NavigationDestination {
    override val route: String = "create"
    override val titleRes: Int = R.string.label_create_top_bar
}

@Composable
fun CreateItemScreen(
    onNavigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    canNavigateBack: Boolean = true,
    modifier: Modifier = Modifier,
    viewModel: CreateItemViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {

    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        InventoryTopAppBar(
            title = stringResource(id = CreateItemDestination.titleRes),
            canNavigateBack = canNavigateBack,
            navigateUp = onNavigateUp
        )
    }) { innerPad ->
        Column(
            modifier = modifier
                .padding(innerPad)
                .fillMaxSize()
        ) {
            InputForm(itemDetails = viewModel.itemUiState.itemDetails, onValueChange = viewModel::updateUiState)
            Button(
                enabled = viewModel.itemUiState.isEntryValid,
                onClick = {
                    coroutineScope.launch {
                        viewModel.saveItem()
                        onNavigateBack()
                    }
                },
                modifier = modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp)
            ) {
                Text(text = stringResource(id = R.string.label_button_save))
            }
        }
    }
}

@Composable
fun InputForm(
    onValueChange: (ItemDetails) -> Unit,
    itemDetails: ItemDetails,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.padding(15.dp)) {
        OutlinedTextField(
            value = itemDetails.name,
            onValueChange = { onValueChange(itemDetails.copy(name = it)) },
            label = { Text(text = stringResource(id = R.string.label_item_name)) },
            singleLine = true,
            enabled = enabled,
            modifier = modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next)
        )

        OutlinedTextField(
            value = itemDetails.price,
            onValueChange = { onValueChange(itemDetails.copy(price = it)) },
            leadingIcon = { Text(Currency.getInstance(Locale.getDefault()).symbol) },
            singleLine = true,
            enabled = enabled,
            modifier = modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Next),
            label = { Text(text = stringResource(id = R.string.label_item_price)) },
        )

        OutlinedTextField(
            value = itemDetails.quantity,
            onValueChange = { onValueChange(itemDetails.copy(quantity = it)) },
            label = { Text(text = stringResource(id = R.string.label_item_qty)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
            singleLine = true,
            enabled = enabled,
            modifier = modifier.fillMaxWidth()
        )

    }
}