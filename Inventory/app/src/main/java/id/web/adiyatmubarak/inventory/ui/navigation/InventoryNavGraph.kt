package id.web.adiyatmubarak.inventory.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import id.web.adiyatmubarak.inventory.ui.screen.CreateItemDestination
import id.web.adiyatmubarak.inventory.ui.screen.CreateItemScreen
import id.web.adiyatmubarak.inventory.ui.screen.HomeDestination
import id.web.adiyatmubarak.inventory.ui.screen.HomeScreen


@Composable
fun InventoryNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {

        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToCreateScreen = { navController.navigate(CreateItemDestination.route) },
                navigateToUpdateScreen = {},
            )
        }

        composable(route = CreateItemDestination.route) {
            CreateItemScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }

//        composable(route = "") {
//
//        }
//
//        composable(route = "") {
//
//        }

    }
}