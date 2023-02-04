package id.web.adiyatmubarak.inventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import id.web.adiyatmubarak.inventory.ui.navigation.InventoryNavHost
import id.web.adiyatmubarak.inventory.ui.screen.HomeScreen
import id.web.adiyatmubarak.inventory.ui.theme.InventoryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InventoryTheme {
                InventoryApp()
            }
        }
    }
}

@Composable
fun InventoryApp(navController: NavHostController = rememberNavController()) {
    InventoryNavHost(navController = navController)
}

@Composable
fun InventoryTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit
) {
    if (canNavigateBack) {
        TopAppBar(
            title = { Text(text = title) },
            modifier = modifier,
            navigationIcon = {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        )
    } else {
        TopAppBar(
            title = { Text(text = title) },
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InventoryTheme {
        HomeScreen(
            navigateToCreateScreen = {},
            navigateToDetailScreen = {},
        )
    }
}