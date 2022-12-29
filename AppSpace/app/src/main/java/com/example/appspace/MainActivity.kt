package com.example.appspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appspace.pojo.ResourceInfo
import com.example.appspace.ui.theme.AppSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun AppSpaceScreen() {
    var state by remember { mutableStateOf(1) }

    val resInfo = when (state) {
        1 -> ResourceInfo(
            imageResId = R.drawable.img1,
            titleResId = R.string.img1_title,
            creatorResId = R.string.img1_by,
            yearResId = R.string.img1_year
        )
        2 -> ResourceInfo(
            imageResId = R.drawable.img2,
            titleResId = R.string.img2_title,
            creatorResId = R.string.img2_by,
            yearResId = R.string.img2_year
        )
        else -> ResourceInfo(
            imageResId = R.drawable.img3,
            titleResId = R.string.img3_title,
            creatorResId = R.string.img3_by,
            yearResId = R.string.img3_year
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        ImageComponent(resId = resInfo.imageResId)
        ContentComponent(
            titleResId = resInfo.titleResId,
            creatorResId = resInfo.creatorResId,
            yearResId = resInfo.yearResId
        )
        ActionComponent(
            nextOnClick = {
                state = when (state) {
                    1 -> 2
                    2 -> 3
                    else -> 1
                }
            },
            prevOnClick = {
                state = when (state) {
                    1 -> 3
                    2 -> 1
                    else -> 2
                }
            },
        )
    }
}

@Composable
fun ImageComponent(@DrawableRes resId: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = resId),
            contentDescription = null,
            modifier = modifier
                .padding(10.dp)
                .border(2.dp, Color.Gray)
        )
    }
}

@Composable
fun ContentComponent(
    @StringRes titleResId: Int,
    @StringRes creatorResId: Int,
    @StringRes yearResId: Int
) {
    Card(
        modifier = Modifier.padding(10.dp),
        elevation = 3.dp
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
        ) {
            Text(
                text = stringResource(id = titleResId),
                fontSize = 30.sp
            )
            Row {
                Text(
                    text = stringResource(id = creatorResId),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(1.dp))
                Text(text = stringResource(id = R.string.text_year, stringResource(id = yearResId)))
            }
        }
    }
}

@Composable
fun ActionComponent(
    nextOnClick: () -> Unit,
    prevOnClick: () -> Unit,
) {
    Row(
        modifier = Modifier.padding(start = 15.dp, end = 15.dp, bottom = 5.dp)
    ) {
        Button(
            onClick = prevOnClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(id = R.string.button_previous))
        }
        Spacer(modifier = Modifier.width(25.dp))
        Button(
            onClick = nextOnClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(id = R.string.button_next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppSpaceTheme {
        AppSpaceScreen()
    }
}