package id.web.adiyatmubarak.inventory.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import id.web.adiyatmubarak.inventory.ui.screen.*


@Composable
fun InventoryNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {

        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToCreateScreen = {
                    navController.navigate(CreateItemDestination.route)
                },
                navigateToDetailScreen = {
                    navController.navigate("${DetailItemDestination.route}/${it}")
                },
            )
        }

        composable(route = CreateItemDestination.route) {
            CreateItemScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }

        composable(
            route = DetailItemDestination.routeWithArgs,
            arguments = listOf(navArgument(DetailItemDestination.itemIdArg){
                type = NavType.IntType
            })
        ) {
            DetailItemScreen(
                onNavigateBack = { navController.navigateUp() },
                onNavigateUp = {}
            )
        }
//
//        composable(route = "") {
//
//        }

    }
}