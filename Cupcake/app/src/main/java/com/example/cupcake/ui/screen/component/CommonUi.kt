package com.example.cupcake.ui.screen.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cupcake.R
import java.text.NumberFormat

@Composable
fun SubTotalComponent(total: Int, modifier: Modifier = Modifier) {
    val totalStr = NumberFormat.getCurrencyInstance().format(total)

    Text(
        text = stringResource(id = R.string.subtotal_price, totalStr),
        modifier = modifier
            .padding(top = 10.dp, bottom = 10.dp, start = 5.dp, end = 5.dp),
        fontWeight = FontWeight.Bold
    )
}