package com.example.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
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
    var expanded by remember { mutableStateOf(false) }
    val name = stringResource(id = dog.nameResId)

    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
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
                Spacer(modifier = Modifier.weight(1f))
                ToggleItemButton(expanded = expanded, onClick = { expanded = !expanded })
            }

            if (expanded) {
                DogHobbyComponent(dogHobbyRes = dog.hobbiesResId)
            }
        }
    }
}

@Composable
fun DogHobbyComponent(@StringRes dogHobbyRes: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.about),
            style = MaterialTheme.typography.h3
        )
        Text(
            text = stringResource(id = dogHobbyRes),
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
private fun ToggleItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(id = R.string.expand_button_content_description)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WoofTheme() {
        WoofApp(dogs = Datasource.loadDogs())
    }
}