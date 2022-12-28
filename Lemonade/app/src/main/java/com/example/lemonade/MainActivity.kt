package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    var squeezeCounter by remember { mutableStateOf(0) }
    var imageState by remember { mutableStateOf(1) }

    val imgRes = when (imageState) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val strRes = when (imageState) {
        1 -> R.string.text_1
        2 -> R.string.text_2
        3 -> R.string.text_3
        else -> R.string.text_4
    }

    val text = stringResource(id = strRes)
    val image = painterResource(id = imgRes)

    when (imageState) {
        1 -> {
            RenderTextAndImage(text = text, image = image) {
                imageState = 2
                squeezeCounter = (1..6).random()
            }
        }
        2 -> {
            RenderTextAndImage(text = text, image = image) {
                squeezeCounter--
                if (squeezeCounter == 0) {
                    imageState = 3
                }
            }
        }
        3 -> {
            RenderTextAndImage(text = text, image = image) {
                imageState = 4
            }
        }
        else -> {
            RenderTextAndImage(text = text, image = image) {
                imageState = 1
            }
        }
    }

}

@Composable
fun RenderTextAndImage(text: String, image: Painter, eventOnImageClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = image, contentDescription = null, modifier = Modifier
                .border(
                    width = 2.dp,
                    color = Color(red = 105, green = 205, blue = 216),
                    shape = RoundedCornerShape(4.dp)
                )
                .clickable(onClick = eventOnImageClick)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}