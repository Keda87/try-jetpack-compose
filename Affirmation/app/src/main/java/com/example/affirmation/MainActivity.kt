package com.example.affirmation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmation.data.Datasource
import com.example.affirmation.model.Affirmation
import com.example.affirmation.ui.theme.AffirmationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AffirmationScreen(affirmationList = Datasource().loadAffirmations())
                }
            }
        }
    }
}

@Composable
fun AffirmationScreen(affirmationList: List<Affirmation>) {
    LazyColumn {
        items(affirmationList) {
            AffirmationCard(data = it)
        }
    }
}

@Composable
fun AffirmationCard(data: Affirmation, modifier: Modifier = Modifier) {

    Card(
        modifier = modifier
            .padding(8.dp)
            .wrapContentHeight(),
        elevation = 4.dp
    ) {
        Column {
            Image(
                painter = painterResource(id = data.imageResId),
                contentDescription = stringResource(id = data.stringResId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = data.stringResId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AffirmationTheme {
        AffirmationScreen(affirmationList = Datasource().loadAffirmations())
    }
}