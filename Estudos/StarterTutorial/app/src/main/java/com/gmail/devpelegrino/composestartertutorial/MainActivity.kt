package com.gmail.devpelegrino.composestartertutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(
                Message(
                    author = "Android",
                    body = "Jetpack Compose"
                )
            )
        }
    }
}

data class Message(val author: String, val body: String)

// Por convenção o padrão Composable começa com PascalCase
@Composable
fun MessageCard(message: Message) {
    Row(Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Profile Photo",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        //Spacer horizontal
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = message.author)
            // Spacer vertical
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = message.body)
        }
    }
}


// Por convenção o preview é Preview+ComposableFunction e só funciona com funções sem parametros
@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!"))
}

