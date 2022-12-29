package com.example.buildagrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.buildagrid.data.DataSource
import com.example.buildagrid.model.Topic
import com.example.buildagrid.ui.theme.BuildAGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuildAGridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CourseScreen(courses = DataSource.topics)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CourseScreen(courses: List<Topic>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
    ) {
        items(courses) {
            TopicCard(topic = it)
        }
    }
}

@Composable
fun TopicCard(topic: Topic) {
    val desc = stringResource(id = topic.strResId)

    Card(
        elevation = 4.dp,
        modifier = Modifier.padding(5.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = topic.imgResId),
                contentDescription = desc,
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = desc,
                    style = MaterialTheme.typography.body2
                )
                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.size(12.dp)
                    )
                    Text(
                        text = topic.count.toString(),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }

}