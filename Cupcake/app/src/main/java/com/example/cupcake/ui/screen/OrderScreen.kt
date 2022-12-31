package com.example.cupcake.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cupcake.R

@Composable
fun OrderScreen(
    onClick: (Int) -> Unit,
    quantityOptions: List<Pair<Int, Int>>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.cupcake),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = stringResource(id = R.string.order_cupcakes),
            style = MaterialTheme.typography.h4
        )

        quantityOptions.forEach {
            ButtonQuantity(
                onClick = {
                    onClick(it.second)
                },
                label = stringResource(id = it.first)
            )
        }
    }
}

@Composable
fun ButtonQuantity(
    onClick: () -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
        modifier = modifier.widthIn(min = 250.dp)
    ) {
        Text(text = label)
    }
}