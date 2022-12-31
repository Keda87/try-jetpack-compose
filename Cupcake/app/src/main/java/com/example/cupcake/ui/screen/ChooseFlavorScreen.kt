package com.example.cupcake.ui.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cupcake.R

@Composable
fun ChooseFlavorScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxWidth()) {
        RadioWithText(isSelected = false, onClick = { /*TODO*/ }, textResId = R.string.vanilla)
        RadioWithText(isSelected = true, onClick = { /*TODO*/ }, textResId = R.string.chocolate)
        RadioWithText(isSelected = false, onClick = { /*TODO*/ }, textResId = R.string.red_velvet)
        RadioWithText(
            isSelected = false,
            onClick = { /*TODO*/ },
            textResId = R.string.salted_caramel
        )
        RadioWithText(isSelected = false, onClick = { /*TODO*/ }, textResId = R.string.coffee)
        Divider(thickness = 3.dp, modifier = Modifier.padding(start = 5.dp, end = 5.dp))
        Text(
            text = stringResource(id = R.string.subtotal_price, 100),
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp, start = 5.dp, end = 5.dp)
                .align(Alignment.End),
            fontWeight = FontWeight.Bold
        )
        ButtonChooseActionFlavor()
    }
}

@Composable
fun RadioWithText(
    isSelected: Boolean,
    onClick: () -> Unit,
    @StringRes textResId: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = isSelected, onClick = onClick)
        Text(text = stringResource(id = textResId))
    }
}

@Composable
fun ButtonChooseActionFlavor(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(start = 5.dp, end = 5.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OutlinedButton(
            modifier = Modifier
                .weight(1f)
                .padding(end = 2.5.dp),
            onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.cancel))
        }
        Button(
            modifier = Modifier
                .weight(1f)
                .padding(start = 2.5.dp),
            onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}