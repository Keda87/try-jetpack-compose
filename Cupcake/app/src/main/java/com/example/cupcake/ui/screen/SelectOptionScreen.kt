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
import androidx.compose.ui.unit.dp
import com.example.cupcake.R
import com.example.cupcake.ui.screen.component.SubTotalComponent

@Composable
fun SelectOptionScreen(options: List<Int>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        options.forEach {
            RadioWithText(isSelected = false, onClick = { /*TODO*/ }, textResId = it)
        }
        Divider(thickness = 3.dp, modifier = Modifier.padding(start = 5.dp, end = 5.dp))
        SubTotalComponent(total = 100, modifier = Modifier.align(Alignment.End))
        ButtonChooseActionButton(
            onCancelClicked = {},
            onNextClicked = {}
        )
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
fun ButtonChooseActionButton(
    onCancelClicked: () -> Unit,
    onNextClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
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
            onClick = onCancelClicked
        ) {
            Text(text = stringResource(id = R.string.cancel))
        }
        Button(
            modifier = Modifier
                .weight(1f)
                .padding(start = 2.5.dp),
            onClick = onNextClicked
        ) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}