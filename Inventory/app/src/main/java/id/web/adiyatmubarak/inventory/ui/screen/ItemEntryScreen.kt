package id.web.adiyatmubarak.inventory.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import id.web.adiyatmubarak.inventory.R

@Composable
fun ItemEntryScreen(modifier: Modifier = Modifier) {
    Column {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text(text = stringResource(id = R.string.label_item_name)) },
            singleLine = true,
            enabled = false,
            modifier = modifier
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text(text = stringResource(id = R.string.label_item_price)) },
            singleLine = true,
            enabled = false,
            modifier = modifier
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text(text = stringResource(id = R.string.label_item_qty)) },
            singleLine = true,
            enabled = false,
            modifier = modifier
        )
    }
}