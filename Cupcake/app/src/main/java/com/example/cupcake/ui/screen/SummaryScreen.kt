package com.example.cupcake.ui.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cupcake.R
import com.example.cupcake.ui.screen.component.SubTotalComponent

@Composable
fun SummaryScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxSize()
    ) {
        ItemDetailComponent(labelResId = R.string.quantity, value = String.format("%d", 10))
        ItemDetailComponent(labelResId = R.string.flavor, value = String.format("%d", 10))
        ItemDetailComponent(labelResId = R.string.pickup_date, value = String.format("%d", 10))
        SubTotalComponent(total = 100, modifier = Modifier.align(Alignment.End))
        Button(
            onClick = { },
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.send))
        }
        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.cancel))
        }
    }
}

@Composable
fun ItemDetailComponent(
    @StringRes labelResId: Int,
    value: String,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
    ) {
        Text(text = stringResource(id = labelResId))
        Text(text = value, fontWeight = FontWeight.Bold)
        Divider(thickness = 2.dp)
    }
}