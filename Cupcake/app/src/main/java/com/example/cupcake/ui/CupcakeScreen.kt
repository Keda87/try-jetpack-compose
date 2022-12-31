package com.example.cupcake.ui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cupcake.R
import com.example.cupcake.data.Datasource
import com.example.cupcake.ui.screen.OrderScreen
import com.example.cupcake.ui.screen.SelectOptionScreen
import com.example.cupcake.ui.screen.SummaryScreen
import com.example.cupcake.ui.viewmodel.OrderViewModel

enum class CupcakeScreen() {
    Start,
    Flavor,
    Pickup,
    Summary
}

@Composable
fun CupCakeAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        modifier = modifier,
        navigationIcon = {
            if (true) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button)
                    )
                }
            }
        }
    )

}

@Preview
@Composable
fun CupcakeApp(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    val viewModel: OrderViewModel = viewModel()

    Scaffold(
        topBar = {
            CupCakeAppBar()
        }
    ) { padValue ->

        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = CupcakeScreen.Start.name,
            modifier = modifier.padding(padValue)
        ) {
            composable(route = CupcakeScreen.Start.name) {
                OrderScreen(
                    onClick = {
                        viewModel.setOrderQuantity(it)
                        navController.navigate(CupcakeScreen.Flavor.name)
                    },
                    quantityOptions = Datasource.quantityOptions
                )
            }

            composable(route = CupcakeScreen.Flavor.name) {
                SelectOptionScreen(
                    onSelectionChanged = { viewModel.setFlavor(it) },
                    onCancelClicked = {
                        cancelOrderAndNavigateToStart(viewModel, navController)
                    },
                    onNextClicked = {
                        navController.navigate(CupcakeScreen.Pickup.name)
                    },
                    subTotal = uiState.price,
                    options = Datasource.flavors.map { resId -> stringResource(id = resId) }
                )
            }

            composable(route = CupcakeScreen.Pickup.name) {
                SelectOptionScreen(
                    onSelectionChanged = { viewModel.setPickUpDate(it) },
                    onCancelClicked = {
                        cancelOrderAndNavigateToStart(viewModel, navController)
                    },
                    onNextClicked = {
                        navController.navigate(CupcakeScreen.Summary.name)
                    },
                    subTotal = uiState.price,
                    options = uiState.pickUpOptions
                )
            }

            composable(route = CupcakeScreen.Summary.name) {
                val ctx = LocalContext.current

                SummaryScreen(
                    data = uiState,
                    onShareClicked = { subject: String, summary: String ->
                        shareOrder(ctx, subject, summary)
                    },
                    onCancelClicked = {
                        cancelOrderAndNavigateToStart(viewModel, navController)
                    }
                )
            }
        }
    }
}

private fun cancelOrderAndNavigateToStart(
    viewModel: OrderViewModel,
    navCtrl: NavHostController
) {
    viewModel.resetOrder()
    navCtrl.popBackStack(CupcakeScreen.Start.name, inclusive = false)
}

private fun shareOrder(ctx: Context, subject: String, summary: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, summary)
    }

    ctx.startActivity(
        Intent.createChooser(
            intent,
            ctx.getString(R.string.new_cupcake_order)
        )
    )
}