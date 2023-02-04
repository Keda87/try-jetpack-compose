package id.web.adiyatmubarak.inventory.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import id.web.adiyatmubarak.inventory.InventoryTopAppBar
import id.web.adiyatmubarak.inventory.R
import id.web.adiyatmubarak.inventory.data.Item
import id.web.adiyatmubarak.inventory.ui.AppViewModelProvider
import id.web.adiyatmubarak.inventory.ui.navigation.NavigationDestination
import java.text.NumberFormat

object HomeDestination : NavigationDestination {
    override val route: String = "home"
    override val titleRes: Int = R.string.app_name
}

@Composable
fun HomeScreen(
    navigateToCreateScreen: () -> Unit,
    navigateToDetailScreen: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {
    val homeUiState by viewModel.homeUiState.collectAsState()

    Scaffold(
        topBar = {
            InventoryTopAppBar(
                title = stringResource(id = HomeDestination.titleRes),
                canNavigateBack = false,
                navigateUp = {},
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToCreateScreen,
                modifier = Modifier.navigationBarsPadding()
            ) {
                Icon(Icons.Filled.Add, "")
            }
        },
        content = { innerPad ->
            Column(
                modifier = modifier
                    .padding(innerPad)
                    .fillMaxHeight()
            ) {
                HomeComponent(entries = homeUiState.itemList, onItemClicked = navigateToDetailScreen)
            }
        },
    )
}

@Composable
fun HomeComponent(
    entries: List<Item>,
    onItemClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(15.dp)) {
        Row(modifier = modifier.padding(bottom = 15.dp)) {
            Text(
                text = stringResource(id = R.string.txt_item),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1.5f)
            )
            Text(
                text = stringResource(id = R.string.txt_price),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = stringResource(id = R.string.txt_qty),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .width(1.dp)
                .padding(bottom = 15.dp)
        )

        if (entries.isNotEmpty()) {
            ListUi(entries = entries, onItemClicked = { onItemClicked(it.id) })
        } else {
            Text(
                text = stringResource(id = R.string.label_no_item),
                fontWeight = FontWeight.Light,
            )
        }
    }
}

@Composable
fun ListUi(
    entries: List<Item>,
    onItemClicked: (Item) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(5.dp)) {
        items(items = entries, key = { it.id }) { item ->
            InventoryItem(data = item, onItemClicked = onItemClicked)
            Divider()
        }
    }
}

@Composable
fun InventoryItem(
    data: Item,
    onItemClicked: (Item) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(8.dp).clickable { onItemClicked(data) }) {
        Text(
            text = data.name,
            modifier = Modifier.weight(1.5f)
        )
        Text(
            text = NumberFormat.getCurrencyInstance().format(data.price),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = String.format("%d", data.quantity),
            modifier = Modifier.weight(1f)
        )
    }
}