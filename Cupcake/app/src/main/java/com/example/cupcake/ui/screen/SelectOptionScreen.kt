package com.example.cupcake.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cupcake.R
import com.example.cupcake.ui.screen.component.SubTotalComponent

@Composable
fun SelectOptionScreen(
    onSelectionChanged: (String) -> Unit,
    onNextClicked: () -> Unit,
    onCancelClicked: () -> Unit,
    subTotal: String,
    options: List<String>,
    modifier: Modifier = Modifier
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        options.forEach {
            RadioWithText(
                label = it,
                isSelected = selectedValue == it,
                onClick = {
                    selectedValue = it
                    onSelectionChanged(selectedValue)
                },
            )
        }
        Divider(thickness = 3.dp, modifier = Modifier.padding(start = 5.dp, end = 5.dp))
        SubTotalComponent(total = subTotal, modifier = Modifier.align(Alignment.End))
        ButtonChooseActionButton(
            nextButtonEnabled = selectedValue.isNotEmpty(),
            onCancelClicked = onCancelClicked,
            onNextClicked = onNextClicked
        )
    }
}

@Composable
fun RadioWithText(
    isSelected: Boolean,
    onClick: () -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = isSelected, onClick = onClick)
        Text(text = label)
    }
}

@Composable
fun ButtonChooseActionButton(
    nextButtonEnabled: Boolean,
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
            enabled = nextButtonEnabled,
            modifier = Modifier
                .weight(1f)
                .padding(start = 2.5.dp),
            onClick = onNextClicked
        ) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}