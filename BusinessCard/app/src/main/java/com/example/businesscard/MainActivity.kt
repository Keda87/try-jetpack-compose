package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.pojos.BusinessCard
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.purple_700)
                ) {
                    val info = BusinessCard(
                        "Adiyat Mubarak",
                        "Technical Lead",
                        "+62 8983865323",
                        "@adiyatmubarak",
                        "adiyatmubarak@gmail.com"
                    )

                    BusinessCardInfo(info)
                }
            }
        }
    }
}

@Composable
fun BusinessCardInfo(info: BusinessCard, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        HeadingScreen(info)
        Spacer(modifier = modifier.weight(1f))
        ContactScreen(info)
    }
}

@Composable
fun HeadingScreen(info: BusinessCard, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier.size(130.dp)
        )
        Text(
            text = info.fullName,
            fontWeight = FontWeight.Light,
            fontSize = 40.sp
        )
        Text(
            text = info.title,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color.Green
        )
    }
}

@Composable
fun ContactScreen(info: BusinessCard, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(bottom = 10.dp, top = 150.dp)
    ) {
        ContactItem(
            icon = painterResource(id = R.drawable.ic_round_phone_24),
            description = info.phone
        )
        ContactItem(
            icon = painterResource(id = R.drawable.ic_baseline_share_24),
            description = info.twitter
        )
        ContactItem(
            icon = painterResource(id = R.drawable.ic_baseline_email_24),
            description = info.email
        )
    }
}

@Composable
fun ContactItem(icon: Painter, description: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 50.dp, end = 50.dp, top = 2.dp, bottom = 2.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color.Green,
            modifier = Modifier
                .wrapContentWidth(Alignment.Start),
        )
        Text( text = description, modifier = Modifier .fillMaxWidth() .padding(start = 20.dp) ) }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        val info = BusinessCard(
            "Adiyat Mubarak",
            "Technical Lead",
            "+62 8983865323",
            "@adiyatmubarak",
            "adiyatmubarak@gmail.com"
        )

        BusinessCardInfo(info)
    }
}