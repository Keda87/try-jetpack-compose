package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val title = stringResource(id = R.string.text_title)
                    val section1 = stringResource(id = R.string.text_section1)
                    val section2 = stringResource(id = R.string.text_section2)
                    val image = painterResource(id = R.drawable.bg_compose_background)

                    DetailArticle(
                        title = title,
                        section1 = section1,
                        section2 = section2,
                        bgImage = image
                    )
                }
            }
        }
    }
}

@Composable
fun DetailArticle(title: String, section1: String, section2: String, bgImage: Painter) {
    Column {
        Image(painter = bgImage, contentDescription = null)
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(all = 16.dp)
        )
        Text(
            text = section1,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        )
        Text(
            text = section2,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(all = 16.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        val title = stringResource(id = R.string.text_title)
        val section1 = stringResource(id = R.string.text_section1)
        val section2 = stringResource(id = R.string.text_section2)
        val image = painterResource(id = R.drawable.bg_compose_background)

        DetailArticle(title = title, section1 = section1, section2 = section2, bgImage = image)
    }
}