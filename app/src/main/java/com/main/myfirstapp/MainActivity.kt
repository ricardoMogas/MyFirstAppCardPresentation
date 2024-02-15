package com.main.myfirstapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.myfirstapp.ui.theme.MyFirstAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Ricardo J Moo Vargas")
                }
            }
        }
    }
}

@Composable
fun Greeting(fullName: String, modifier: Modifier = Modifier) {
    // add background
    Column(modifier = modifier
        .padding(20.dp)
        .size(300.dp, 500.dp)) {
        // First section
        Image(
            painter = painterResource(id = R.drawable.my_photo),
            contentDescription = stringResource(id = R.string.my_photo),
            modifier = Modifier
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
        )
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "$fullName",
                modifier = Modifier.padding(8.dp),
                fontSize = 24.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "Desarrollador de Software",
                modifier = Modifier.padding(8.dp),
            )
        }
        Spacer(modifier = Modifier.height(30.dp)) // Add some spacing between the sections
        // Second section
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Icon(
                Icons.Filled.MailOutline,
                contentDescription = "User Icon",
                modifier = Modifier
                    .padding(8.dp)
                    .size(30.dp)
            ) // Add the icon here
            Text("al066208@uacam.mx")
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Icon(
                Icons.Filled.Call,
                contentDescription = "User Icon",
                modifier = Modifier
                    .padding(8.dp)
                    .size(30.dp)
            ) // Add the icon here
            Text("+52 981 593 7333")
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Icon(
                painter = painterResource(id = R.drawable.github_mark),
                contentDescription = "User Icon",
                modifier = Modifier
                    .padding(8.dp)
                    .size(30.dp)
            ) // Add the icon here
            val annotatedText = AnnotatedString(text = "Follow me on Github", spanStyle = SpanStyle(color = Color.Blue))
            ClickableText(text = annotatedText, onClick = { offset ->
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/your_username"))
            })
        }
        // Button section
        val count = remember { mutableStateOf(0) }
        val context = LocalContext.current
        Button(onClick = {
            count.value++
            Toast.makeText(context, "Button clicked ${count.value} times!", Toast.LENGTH_SHORT).show()
        }, modifier = Modifier.align(Alignment.CenterHorizontally)) { // Center the button horizontally
            Text("Contact me!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstAppTheme {
        Greeting("Ricardo J Moo Vargas")
    }
}