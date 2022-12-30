package com.example.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.woof.data.Datasource
import com.example.woof.model.Dog
import com.example.woof.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WoofApp(dogs = Datasource.loadDogs())
                }
            }
        }
    }
}

@Composable
fun WoofApp(dogs: List<Dog>) {
    Scaffold(
        topBar = {
            WoofTopBar()
        }
    ) {
        LazyColumn {
            items(dogs) {
                DogItemComponent(dog = it)
            }
        }
    }

}

@Composable
fun WoofTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_woof_logo),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier
                .size(64.dp)
                .padding(8.dp)
        )
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1
        )

    }
}

@Composable
fun DogItemComponent(dog: Dog) {
    val name = stringResource(id = dog.nameResId)
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(MaterialTheme.colors.surface)
        ) {
            Image(
                painter = painterResource(id = dog.imageResId),
                contentDescription = name,
                modifier = Modifier
                    .size(64.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(50)),
                contentScale = ContentScale.Crop,

                )
            Column(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.h2
                )
                Text(
                    text = stringResource(id = R.string.years_old, dog.age),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WoofTheme(darkTheme = true) {
        WoofApp(dogs = Datasource.loadDogs())
    }
}