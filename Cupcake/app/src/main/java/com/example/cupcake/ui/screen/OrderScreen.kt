package com.example.cupcake.ui.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cupcake.R
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun OrderScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CupCakeTopBar(
                canGoBack = false,
                onBackButton = { }
            )
        }
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
            ButtonQuantity(onClick = { /*TODO*/ }, textResId = R.string.one_cupcake)
            ButtonQuantity(onClick = { /*TODO*/ }, textResId = R.string.six_cupcakes)
            ButtonQuantity(onClick = { /*TODO*/ }, textResId = R.string.twelve_cupcakes)
        }
    }
}

@Composable
fun ButtonQuantity(
    onClick: () -> Unit,
    @StringRes textResId: Int,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
        modifier = modifier.widthIn(min = 250.dp)
    ) {
        Text(text = stringResource(id = textResId))
    }
}

@Composable
fun CupCakeTopBar(
    canGoBack: Boolean,
    onBackButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        modifier = modifier,
        navigationIcon = {
            if (canGoBack) {
                IconButton(onClick = onBackButton) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button)
                    )
                }
            }
        }
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CupcakeTheme {
        OrderScreen()
    }
}

