package com.gmail.devpelegrino.composestartertutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

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
    Column {
        Text(text = message.author)
        Text(text = message.body)
    }
}


// Por convenção o preview é Preview+ComposableFunction e só funciona com funções sem parametros
@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!"))
}

