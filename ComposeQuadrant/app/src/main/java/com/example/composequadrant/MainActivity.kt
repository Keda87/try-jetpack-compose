package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    QuadrantScreen()
                }
            }
        }
    }
}

@Composable
fun QuadrantScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            QuadrantInformationCard(
                title = stringResource(id = R.string.text_title1),
                content = stringResource(id = R.string.text_content1),
                color = Color.Green,
                modifier = Modifier.weight(1f)
            )

            QuadrantInformationCard(
                title = stringResource(id = R.string.text_title2),
                content = stringResource(id = R.string.text_content2),
                color = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }

        Row(Modifier.weight(1f)) {
            QuadrantInformationCard(
                title = stringResource(id = R.string.text_title3),
                content = stringResource(id = R.string.text_content3),
                color = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            QuadrantInformationCard(
                title = stringResource(id = R.string.text_title4),
                content = stringResource(id = R.string.text_content4),
                color = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Composable
fun QuadrantInformationCard(
    title: String,
    content: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = color)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        QuadrantScreen()
    }
}