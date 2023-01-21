package id.web.adiyatmubarak.inventory.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import id.web.adiyatmubarak.inventory.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column {
        TitleUi()
        ListUi()
    }
}

@Composable
fun TitleUi(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(15.dp)) {
        Row(modifier = modifier.padding(bottom = 15.dp)) {
            Text(
                text = stringResource(id = R.string.txt_item),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = stringResource(id = R.string.txt_price),
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = stringResource(id = R.string.txt_qty),
                fontWeight = FontWeight.Bold,
            )
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .width(1.dp)
                .padding(bottom = 15.dp)
        )
        Text(
            text = stringResource(id = R.string.label_no_item),
            fontWeight = FontWeight.Light,
        )
    }
}

@Composable
fun ListUi(modifier: Modifier = Modifier) {

}

@Composable
fun InventoryItem(modifier: Modifier = Modifier) {
    // TODO:
}