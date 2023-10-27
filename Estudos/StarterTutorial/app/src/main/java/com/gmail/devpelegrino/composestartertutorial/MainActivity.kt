package com.gmail.devpelegrino.composestartertutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gmail.devpelegrino.composestartertutorial.ui.theme.ComposeStarterTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard("vamo que vamo")
        }
    }
}

// Por convenção o padrão Composable começa com PascalCase
@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name")
}


// Por convenção o preview é Preview+ComposableFunction e só funciona com funções sem parametros
@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard("Olá sou um preview")
}

