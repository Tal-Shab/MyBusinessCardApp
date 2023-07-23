package com.example.mybusinesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybusinesscardapp.ui.theme.MyBusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        name = stringResource(id = R.string.user_name_text),
                        title = stringResource(id = R.string.title_text),
                        phone = stringResource(id = R.string.phone_num_text),
                        linkdin = stringResource(id = R.string.linkdin_text),
                        email = stringResource(id = R.string.email_text)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, title : String, phone: String,
                 linkdin : String, email: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Icon(
            Icons.Rounded.Face,
            contentDescription = null,
            tint = colorResource(id = R.color.purple_200),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(48.dp)
            )
        Text(
            text = name,
            fontSize = 32.sp,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
            )

        Text(
            text = title,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            color = Color.LightGray,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        Spacer(modifier = Modifier.height(20.dp))
        InfoLine(icon = Icons.Rounded.Phone, data = phone)
        InfoLine(icon = Icons.Rounded.Info, data = linkdin)
        InfoLine(icon = Icons.Rounded.Email, data = email)
    }

}

@Composable
fun InfoLine(icon: ImageVector, data : String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = data)
        Icon(
            icon,
            tint = colorResource(id = R.color.purple_200),
            contentDescription = null
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyBusinessCardAppTheme {
        BusinessCard("Tal Shabadash", "BadAss Compose Developer" , "+12(34)567", "linkdin.com", "user@mail")
    }
}