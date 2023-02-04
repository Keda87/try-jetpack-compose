package id.web.adiyatmubarak.inventory.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import id.web.adiyatmubarak.inventory.R
import id.web.adiyatmubarak.inventory.ui.navigation.NavigationDestination


object DetailItemDestination : NavigationDestination {
    override val route: String = "detail"
    override val titleRes: Int = R.string.label_create_top_bar

    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@Composable
fun DetailItemScreen(
    onNavigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    canNavigateBack: Boolean = true,
    modifier: Modifier = Modifier) {

}